package com.nydev.models.atom

/**
 * Represents a specific atom instance in a molecule or structure.
 *
 * Unlike [Symbol], which represents an element type (e.g. Carbon),
 * an [Atom] represents a distinct particle (e.g. "Carbon atom #1").
 */
class Atom(val symbol: Symbol)
