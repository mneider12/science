package com.nydev.models.atom

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class SymbolTest {

    @ParameterizedTest
    @EnumSource()
    fun display_returns(symbol: Symbol) {
        val expected = symbol.name.lowercase().replaceFirstChar { it.uppercase() }
        assertEquals(expected, symbol.display)
    }
}