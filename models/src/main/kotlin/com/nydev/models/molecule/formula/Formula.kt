package com.nydev.models.molecule.formula

import com.nydev.models.atom.Symbol

class Formula private constructor(val fragments: List<Fragment>) {
    companion object {
        /**
         * Create a new formula.
         *
         * Currently only supports single letter atoms with no counts. E.g. HCN
         */
        fun create(formulaString: String): Formula {
            val fragments = mutableListOf<Fragment>()

            formulaString.forEach {
                if (!it.isUpperCase()) {
                    throw IllegalArgumentException("Currently only capital letters are allowed in formulas")
                }
                val symbol = try {
                    Symbol.valueOf(it.toString())
                } catch (e: IllegalArgumentException) {
                    throw IllegalArgumentException("Unsupported symbol: $it")
                }
                fragments.addLast(AtomCount(symbol, 1))
            }

            return Formula(fragments.toList())
        }
    }
}
