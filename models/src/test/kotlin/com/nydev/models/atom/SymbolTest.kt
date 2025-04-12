package com.nydev.models.atom

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SymbolTest {
    @Test fun display_H_returnsH() {
        assertEquals("H", Symbol.H.display)
    }
}