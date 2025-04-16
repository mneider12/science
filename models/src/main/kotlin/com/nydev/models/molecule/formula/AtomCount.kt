package com.nydev.models.molecule.formula

import com.nydev.models.atom.Symbol

/**
 * One pair of atom and count as part of a molecular formula.
 *
 * E.g. in the formula CH4, C1 and H4 are AtomCounts.
 */
data class AtomCount(val symbol: Symbol, val count: Int) : Fragment
