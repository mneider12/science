package com.nydev.models.molecule

import com.nydev.models.molecule.formula.Formula
import kotlin.test.Test
import kotlin.test.assertEquals

class MoleculeTest {

    @Test
    fun createMolecule() {
        val formula = Formula.create("H2O")
        val molecule = Molecule(formula)
        
        assertEquals(formula, molecule.formula)
    }
}
