package com.nydev.calculations.periodictable

import com.nydev.models.atom.Symbol
import kotlin.test.Test
import kotlin.test.assertEquals

class GroupTest {
    private val calculator = Group()

    @Test
    fun testGroups() {
        assertEquals(1, calculator.get(Symbol.H))
        assertEquals(1, calculator.get(Symbol.LI))
        assertEquals(2, calculator.get(Symbol.BE))
        assertEquals(14, calculator.get(Symbol.C))
        assertEquals(16, calculator.get(Symbol.O))
        assertEquals(17, calculator.get(Symbol.CL))
        assertEquals(18, calculator.get(Symbol.HE))
        assertEquals(18, calculator.get(Symbol.OG))
    }
}
