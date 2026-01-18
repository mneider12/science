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
            var i = 0

            fun parse(closer: Char? = null): List<Fragment> {
                val fragments = mutableListOf<Fragment>()

                while (i < input.length) {
                    val char = input[i]

                    if (char == closer) {
                        return fragments
                    }

                    if (char in BRACE_PAIRS) {
                        val expectedCloser = BRACE_PAIRS[char]!!
                        i++
                        val parsedGroup = parse(expectedCloser)
                        if (i >= input.length || input[i] != expectedCloser) {
                           throw IllegalArgumentException("Mismatched or missing closing brace for $char starting at index $i")
                        }
                        i++ // consume closer
                        val count = parseCount()
                        fragments.add(Group(parsedGroup, count))
                    } else if (BRACE_PAIRS.containsValue(char)) {
                        // Found a closer but it wasn't the one we expected (or we expected none)
                         if (closer == null) {
                             throw IllegalArgumentException("Unexpected closing brace $char at index $i")
                         } else {
                             // This should be handled by the check inside the recursive call, 
                             // effectively we return the fragments and let the caller check if it matched.
                             return fragments
                         }
                    } else if (char.isUpperCase()) {
                        fragments.add(parseAtom())
                    } else {
                        throw IllegalArgumentException("Unexpected character $char at index $i")
                    }
                }
                if (closer != null) {
                    throw IllegalArgumentException("Missing closing brace $closer")
                }
                return fragments
            }

            private fun parseAtom(): AtomCount {
                val startSymbol = i
                i++
                while (i < input.length && input[i].isLowerCase()) {
                    i++
                }
                val symbolString = input.substring(startSymbol, i)
                val symbol = try {
                    Symbol.valueOf(symbolString.uppercase())
                } catch (e: IllegalArgumentException) {
                    throw IllegalArgumentException("Unsupported symbol: $symbolString")
                }

                val count = parseCount()
                return AtomCount(symbol, count)
            }

            private fun parseCount(): Int {
                if (i < input.length && input[i].isDigit()) {
                    val start = i
                    while (i < input.length && input[i].isDigit()) {
                        i++
                    }
                    return input.substring(start, i).toInt()
                }
                return 1
            }
        }
    }
}
