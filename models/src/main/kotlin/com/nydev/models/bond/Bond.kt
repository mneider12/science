package com.nydev.models.bond

import com.nydev.models.atom.Atom

/**
 * Represents a chemical bond between two atoms.
 */
data class Bond(val atoms: Pair<Atom, Atom>) {
    constructor(atomA: Atom, atomB: Atom) : this(atomA to atomB)
}
