package com.nydev.models.molecule.formula

import com.nydev.models.atom.Symbol

class Formula private constructor(val fragments: List<Fragment>) {
    companion object {
        /**
         * Create a new formula.
         *
         * Supports single letter atoms with counts. E.g. HCN, O2
         */
        private val BRACE_PAIRS = mapOf(
            '(' to ')',
            '[' to ']',
            '{' to '}'
        )

        fun create(formulaString: String): Formula {
            return Formula(Parser(formulaString).parse())
        }

        private class Parser(val input: String) {
            var currentIndex = 0

            fun parse(expectedCloser: Char? = null): List<Fragment> {
                val fragments = mutableListOf<Fragment>()

                while (currentIndex < input.length) {
                    val currentChar = input[currentIndex]

                    if (currentChar == expectedCloser) {
                        return fragments
                    }

                    if (currentChar in BRACE_PAIRS) {
                        fragments.add(parseGroup(currentChar))
                    } else if (BRACE_PAIRS.containsValue(currentChar)) {
                        handleUnexpectedCloser(currentChar, expectedCloser)
                        // If we returned, it means it matched expectedCloser in the recursive call
                        return fragments
                    } else if (currentChar.isUpperCase()) {
                        fragments.add(parseAtom())
                    } else {
                        throw IllegalArgumentException("Unexpected character $currentChar at index $currentIndex")
                    }
                }
                if (expectedCloser != null) {
                    throw IllegalArgumentException("Missing closing brace $expectedCloser")
                }
                return fragments
            }

            private fun parseGroup(opener: Char): Group {
                val expectedCloser = BRACE_PAIRS[opener]!!
                currentIndex++ // consume opener
                
                val groupFragments = parse(expectedCloser)
                
                if (currentIndex >= input.length || input[currentIndex] != expectedCloser) {
                    throw IllegalArgumentException("Mismatched or missing closing brace for $opener starting at index $currentIndex")
                }
                currentIndex++ // consume closer
                val count = parseCount()
                return Group(groupFragments, count)
            }

            private fun handleUnexpectedCloser(closer: Char, expectedCloser: Char?) {
                if (expectedCloser == null) {
                    throw IllegalArgumentException("Unexpected closing brace $closer at index $currentIndex")
                }
                // If it matches expectedCloser, it's handled by the return in the parse loop. 
                // Any other closer mismatch logic effectively bubbles up or is handled by the caller checking the return.
            }

            private fun parseAtom(): AtomCount {
                val startSymbol = currentIndex
                currentIndex++
                while (currentIndex < input.length && input[currentIndex].isLowerCase()) {
                    currentIndex++
                }
                val symbolString = input.substring(startSymbol, currentIndex)
                val symbol = try {
                    Symbol.valueOf(symbolString.uppercase())
                } catch (e: IllegalArgumentException) {
                    throw IllegalArgumentException("Unsupported symbol: $symbolString")
                }

                val count = parseCount()
                return AtomCount(symbol, count)
            }

            private fun parseCount(): Int {
                if (currentIndex < input.length && input[currentIndex].isDigit()) {
                    val start = currentIndex
                    while (currentIndex < input.length && input[currentIndex].isDigit()) {
                        currentIndex++
                    }
                    return input.substring(start, currentIndex).toInt()
                }
                return 1
            }
        }
    }
}
