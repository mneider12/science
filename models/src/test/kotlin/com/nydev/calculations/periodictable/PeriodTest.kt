package com.nydev.calculations.periodictable

import com.nydev.models.atom.Symbol
import kotlin.test.Test
import kotlin.test.assertEquals

class PeriodTest {
    private val calculator = Period()

    @Test
    fun testPeriods() {
        assertEquals(1, calculator.get(Symbol.H))
        assertEquals(1, calculator.get(Symbol.HE))
        assertEquals(2, calculator.get(Symbol.LI))
        assertEquals(2, calculator.get(Symbol.NE))
        assertEquals(3, calculator.get(Symbol.NA))
        assertEquals(3, calculator.get(Symbol.AR))
        assertEquals(7, calculator.get(Symbol.FR))
        assertEquals(7, calculator.get(Symbol.OG))
    }
}
