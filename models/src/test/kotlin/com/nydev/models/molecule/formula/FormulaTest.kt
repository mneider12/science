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

    @Test fun create_multiLetterSymbol_setsAtomCount() {
        val formula = Formula.create("He")
        assertEquals(AtomCount(Symbol.HE, 1), formula.fragments.single())
    }

    @Test fun create_multiLetterSymbolWithCount_setsAtomCount() {
        val formula = Formula.create("Na2")
        assertEquals(AtomCount(Symbol.NA, 2), formula.fragments.single())
    }

    @Test fun create_mixedSymbols_setsAtomCounts() {
        val formula = Formula.create("NaCl")
        val expected = listOf(
            AtomCount(Symbol.NA, 1),
            AtomCount(Symbol.CL, 1),
        )
        assertEquals(expected, formula.fragments)
    }

    @Test fun create_lowerCase_notSupported() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Formula.create("he")
        }

        assertEquals("Unexpected character h at index 0", exception.message)
    }

    @Test fun create_unsupportedSymbol_notSupported() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Formula.create("A")
        }

        assertEquals("Unsupported symbol: A", exception.message)
    }

    @Test fun create_unknownSymbol_threeDigits_notSupported() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Formula.create("Uue")
        }

        assertEquals("Unsupported symbol: Uue", exception.message)
    }

    @Test fun create_nestedGroup_parsedCorrectly() {
        val formula = Formula.create("(NH4)2SO4")
        val expected = listOf(
            Group(
                listOf(
                    AtomCount(Symbol.N, 1),
                    AtomCount(Symbol.H, 4)
                ), 2
            ),
            AtomCount(Symbol.S, 1),
            AtomCount(Symbol.O, 4)
        )
        assertEquals(expected, formula.fragments)
    }

    @Test fun create_simpleGroup_parsedCorrectly() {
        val formula = Formula.create("Ca(OH)2")
        val expected = listOf(
            AtomCount(Symbol.CA, 1),
            Group(
                listOf(
                    AtomCount(Symbol.O, 1),
                    AtomCount(Symbol.H, 1)
                ), 2
            )
        )
        assertEquals(expected, formula.fragments)
    }

    @Test fun create_bracketsAndParentheses_parsedCorrectly() {
        val formula = Formula.create("K4[Fe(CN)6]")
        val expected = listOf(
            AtomCount(Symbol.K, 4),
            Group(
                listOf(
                    AtomCount(Symbol.FE, 1),
                    Group(
                        listOf(
                            AtomCount(Symbol.C, 1),
                            AtomCount(Symbol.N, 1)
                        ), 6
                    )
                ), 1
            )
        )
        assertEquals(expected, formula.fragments)
    }

    @Test fun create_braces_parsedCorrectly() {
        val formula = Formula.create("{H2O}10")
        val expected = listOf(
            Group(
                listOf(
                    AtomCount(Symbol.H, 2),
                    AtomCount(Symbol.O, 1)
                ), 10
            )
        )
        assertEquals(expected, formula.fragments)
    }

    @Test fun create_mismatchedBraces_throwsException() {
         assertThrows(IllegalArgumentException::class.java) {
             Formula.create("(OH]")
         }
    }
}