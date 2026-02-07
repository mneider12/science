package com.nydev.models.molecule

import com.nydev.models.atom.Atom
import com.nydev.models.bond.Bond

class Molecule(val structure: Map<Atom, List<Bond>>) {
}
