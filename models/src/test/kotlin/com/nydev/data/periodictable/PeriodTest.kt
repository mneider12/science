package com.nydev.data.periodictable

import com.nydev.models.atom.Symbol
import kotlin.test.Test
import kotlin.test.assertEquals

class PeriodTest {
    private val period = Period()

    @Test
    fun testPeriods() {
        assertEquals(1, period.get(Symbol.H))
        assertEquals(1, period.get(Symbol.HE))
        assertEquals(2, period.get(Symbol.LI))
        assertEquals(2, period.get(Symbol.NE))
        assertEquals(3, period.get(Symbol.NA))
        assertEquals(3, period.get(Symbol.AR))
        assertEquals(7, period.get(Symbol.FR))
        assertEquals(7, period.get(Symbol.OG))
    }
}
