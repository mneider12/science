package com.nydev.data

import com.nydev.models.atom.Symbol

class Valence {
    fun get(symbol: Symbol): Int {
        return when (symbol) {
            Symbol.H, Symbol.LI, Symbol.NA, Symbol.K, Symbol.RB, Symbol.CS, Symbol.FR -> 1
            Symbol.BE, Symbol.MG, Symbol.CA, Symbol.SR, Symbol.BA, Symbol.RA -> 2
            Symbol.B, Symbol.AL, Symbol.GA, Symbol.IN, Symbol.TL, Symbol.NH -> 3
            Symbol.C, Symbol.SI, Symbol.GE, Symbol.SN, Symbol.PB, Symbol.FL -> 4
            Symbol.N, Symbol.P, Symbol.AS, Symbol.SB, Symbol.BI, Symbol.MC -> 5
            Symbol.O, Symbol.S, Symbol.SE, Symbol.TE, Symbol.PO, Symbol.LV -> 6
            Symbol.F, Symbol.CL, Symbol.BR, Symbol.I, Symbol.AT, Symbol.TS -> 7
            Symbol.HE -> 2
            Symbol.NE, Symbol.AR, Symbol.KR, Symbol.XE, Symbol.RN, Symbol.OG -> 8
            else -> 0 // Default for transition metals etc. for now
        }
    }
}
