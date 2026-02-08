package com.nydev.data

import com.nydev.models.atom.Symbol
import kotlin.test.Test
import kotlin.test.assertEquals

class ValenceTest {
    private val valence = Valence()

    @Test
    fun testCommonElements() {
        assertEquals(1, valence.get(Symbol.H))
        assertEquals(4, valence.get(Symbol.C))
        assertEquals(5, valence.get(Symbol.N))
        assertEquals(6, valence.get(Symbol.O))
        assertEquals(7, valence.get(Symbol.F))
        assertEquals(7, valence.get(Symbol.CL))
    }

    @Test
    fun testNobleGases() {
        assertEquals(2, valence.get(Symbol.HE))
        assertEquals(8, valence.get(Symbol.NE))
        assertEquals(8, valence.get(Symbol.AR))
    }

    @Test
    fun testAlkaliMetals() {
        assertEquals(1, valence.get(Symbol.LI))
        assertEquals(1, valence.get(Symbol.NA))
    }
}
