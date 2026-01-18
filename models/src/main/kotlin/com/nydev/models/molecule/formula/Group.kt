package com.nydev.models.molecule.formula

/**
 * A grouped segment of a molecule, potentially with a multiplier.
 *
 * e.g. in (NH4)2SO4, (NH4)2 is a Group containing N and H4, with a count of 2.
 */
data class Group(val fragments: List<Fragment>, val count: Int) : Fragment
