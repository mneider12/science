package com.nydev.calculations

import com.nydev.models.molecule.formula.Formula
import kotlin.test.Test
import kotlin.test.assertEquals

class MolecularWeightTest {

    private val calculator = MolecularWeight()

    @Test
    fun calculateWater() {
        // H2O: (2 * 1.008) + 15.999 = 2.016 + 15.999 = 18.015
        val formula = Formula.create("H2O")
        val weight = calculator.calculate(formula)
        assertEquals(18.015, weight, 0.0001)
    }

    @Test
    fun calculateMethane() {
        // CH4: 12.011 + (4 * 1.008) = 12.011 + 4.032 = 16.043
        val formula = Formula.create("CH4")
        val weight = calculator.calculate(formula)
        assertEquals(16.043, weight, 0.0001)
    }
    
    @Test
    fun calculateGroup() {
        // Ca(OH)2: 40.078 + 2 * (15.999 + 1.008) 
        // = 40.078 + 2 * 17.007 
        // = 40.078 + 34.014 
        // = 74.092
        val formula = Formula.create("Ca(OH)2")
        val weight = calculator.calculate(formula)
        assertEquals(74.092, weight, 0.0001)
    }
}
