package com.nydev.models.molecule.formula

import com.nydev.models.atom.Symbol
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FormulaTest {
    @Test fun create_singleSymbol_setsSingleAtomCount() {
        val formula = Formula.create("H")

        assertEquals(AtomCount(Symbol.valueOf("H"), 1), formula.fragments.single())
    }

    @Test fun create_multipleSymbols_setsAtomCounts() {
        val formula = Formula.create("HCN")

        val expected = listOf(
            AtomCount(Symbol.valueOf("H"), 1),
            AtomCount(Symbol.valueOf("C"), 1),
            AtomCount(Symbol.valueOf("N"), 1),
        )
        assertEquals(expected, formula.fragments)
    }

    @Test fun create_singleSymbolWithCount_setsAtomCount() {
        val formula = Formula.create("O2")

        assertEquals(AtomCount(Symbol.valueOf("O"), 2), formula.fragments.single())
    }

    @Test fun create_lowerCase_notSupported() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Formula.create("He")
        }

        assertEquals("Currently only capital letters are allowed in formulas", exception.message)
    }

    @Test fun create_unsupportedSymbol_notSupported() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Formula.create("A")
        }

        assertEquals("Unsupported symbol: A", exception.message)
    }
}