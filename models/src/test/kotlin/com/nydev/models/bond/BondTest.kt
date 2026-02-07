package com.nydev.models.bond

import com.nydev.models.atom.Atom
import com.nydev.models.atom.Symbol
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class BondTest {

    @Test
    fun createBond() {
        val c1 = Atom(Symbol.C)
        val h1 = Atom(Symbol.H)
        
        val bond = Bond(c1, h1)
        
        assertEquals(c1, bond.atoms.first)
        assertEquals(h1, bond.atoms.second)
    }

    @Test
    fun distinctAtoms() {
        val c1 = Atom(Symbol.C)
        val c2 = Atom(Symbol.C)

        assertNotEquals(c1, c2, "Different Atom instances should not be equal")
    }
}
