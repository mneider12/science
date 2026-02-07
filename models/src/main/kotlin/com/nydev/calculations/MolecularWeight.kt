package com.nydev.calculations

import com.nydev.models.atom.AtomicWeights
import com.nydev.models.molecule.Molecule
import com.nydev.models.molecule.formula.AtomCount
import com.nydev.models.molecule.formula.Fragment
import com.nydev.models.molecule.formula.Group

class MolecularWeight {
    fun calculate(molecule: Molecule): Double {
        return molecule.formula.fragments.sumOf { calculateFragment(it) }
    }

    private fun calculateFragment(fragment: Fragment): Double {
        return when (fragment) {
            is AtomCount -> AtomicWeights.get(fragment.symbol) * fragment.count
            is Group -> fragment.fragments.sumOf { calculateFragment(it) } * fragment.count
        }
    }
}
