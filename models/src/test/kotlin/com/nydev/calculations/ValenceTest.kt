package com.nydev.calculations

import com.nydev.models.atom.Symbol
import kotlin.test.Test
import kotlin.test.assertEquals

class ValenceTest {
    private val calculator = Valence()

    @Test
    fun testCommonElements() {
        assertEquals(1, calculator.get(Symbol.H))
        assertEquals(4, calculator.get(Symbol.C))
        assertEquals(5, calculator.get(Symbol.N))
        assertEquals(6, calculator.get(Symbol.O))
        assertEquals(7, calculator.get(Symbol.F))
        assertEquals(7, calculator.get(Symbol.CL))
    }

    @Test
    fun testNobleGases() {
        assertEquals(2, calculator.get(Symbol.HE))
        assertEquals(8, calculator.get(Symbol.NE))
        assertEquals(8, calculator.get(Symbol.AR))
    }

    @Test
    fun testAlkaliMetals() {
        assertEquals(1, calculator.get(Symbol.LI))
        assertEquals(1, calculator.get(Symbol.NA))
    }
}
