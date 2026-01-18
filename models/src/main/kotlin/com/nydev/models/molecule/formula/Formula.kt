package com.nydev.models.molecule.formula

import com.nydev.models.atom.Symbol

class Formula private constructor(val fragments: List<Fragment>) {
    companion object {
        /**
         * Create a new formula.
         *
         * Supports single letter atoms with counts. E.g. HCN, O2
         */
        fun create(formulaString: String): Formula {
            val fragments = mutableListOf<Fragment>()

            var i = 0
            while (i < formulaString.length) {
                val startSymbol = i
                val char = formulaString[i]
                if (!char.isUpperCase()) {
                    throw IllegalArgumentException("Currently only capital letters are allowed in formulas")
                }
                i++
                while (i < formulaString.length && formulaString[i].isLowerCase()) {
                    i++
                }
                val symbolString = formulaString.substring(startSymbol, i)

                val symbol = try {
                    Symbol.valueOf(symbolString.uppercase())
                } catch (e: IllegalArgumentException) {
                    throw IllegalArgumentException("Unsupported symbol: $symbolString")
                }

                val count = if (i < formulaString.length && formulaString[i].isDigit()) {
                    val start = i
                    while (i < formulaString.length && formulaString[i].isDigit()) {
                        i++
                    }
                    formulaString.substring(start, i).toInt()
                } else {
                    1
                }
                fragments.addLast(AtomCount(symbol, count))
            }

            return Formula(fragments.toList())
        }
    }
}
