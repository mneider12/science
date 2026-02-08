package com.nydev.data.periodictable

import com.nydev.models.atom.Symbol
import kotlin.test.Test
import kotlin.test.assertEquals

class GroupTest {
    private val group = Group()

    @Test
    fun testGroups() {
        assertEquals(1, group.get(Symbol.H))
        assertEquals(1, group.get(Symbol.LI))
        assertEquals(2, group.get(Symbol.BE))
        assertEquals(14, group.get(Symbol.C))
        assertEquals(16, group.get(Symbol.O))
        assertEquals(17, group.get(Symbol.CL))
        assertEquals(18, group.get(Symbol.HE))
        assertEquals(18, group.get(Symbol.OG))
    }
}
