package com.nydev.models.molecule

import com.nydev.models.atom.Atom
import com.nydev.models.atom.Symbol
import com.nydev.models.bond.Bond
import kotlin.test.Test
import kotlin.test.assertEquals

class MoleculeTest {

    @Test
    fun createMolecule() {
        val h1 = Atom(Symbol.H)
        val h2 = Atom(Symbol.H)
        val bond = Bond(h1, h2)
        
        val structure = mapOf(
            h1 to listOf(bond),
            h2 to listOf(bond)
        )
        
        val molecule = Molecule(structure)
        
        assertEquals(structure, molecule.structure)
    }
}
