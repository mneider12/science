package com.nydev.calculations.periodictable

import com.nydev.models.atom.Symbol

class Group {
    fun get(symbol: Symbol): Int {
        return when (symbol) {
            Symbol.H, Symbol.LI, Symbol.NA, Symbol.K, Symbol.RB, Symbol.CS, Symbol.FR -> 1
            Symbol.BE, Symbol.MG, Symbol.CA, Symbol.SR, Symbol.BA, Symbol.RA -> 2
            Symbol.SC, Symbol.Y, Symbol.LU, Symbol.LR -> 3
            Symbol.TI, Symbol.ZR, Symbol.HF, Symbol.RF -> 4
            Symbol.V, Symbol.NB, Symbol.TA, Symbol.DB -> 5
            Symbol.CR, Symbol.MO, Symbol.W, Symbol.SG -> 6
            Symbol.MN, Symbol.TC, Symbol.RE, Symbol.BH -> 7
            Symbol.FE, Symbol.RU, Symbol.OS, Symbol.HS -> 8
            Symbol.CO, Symbol.RH, Symbol.IR, Symbol.MT -> 9
            Symbol.NI, Symbol.PD, Symbol.PT, Symbol.DS -> 10
            Symbol.CU, Symbol.AG, Symbol.AU, Symbol.RG -> 11
            Symbol.ZN, Symbol.CD, Symbol.HG, Symbol.CN -> 12
            Symbol.B, Symbol.AL, Symbol.GA, Symbol.IN, Symbol.TL, Symbol.NH -> 13
            Symbol.C, Symbol.SI, Symbol.GE, Symbol.SN, Symbol.PB, Symbol.FL -> 14
            Symbol.N, Symbol.P, Symbol.AS, Symbol.SB, Symbol.BI, Symbol.MC -> 15
            Symbol.O, Symbol.S, Symbol.SE, Symbol.TE, Symbol.PO, Symbol.LV -> 16
            Symbol.F, Symbol.CL, Symbol.BR, Symbol.I, Symbol.AT, Symbol.TS -> 17
            Symbol.HE, Symbol.NE, Symbol.AR, Symbol.KR, Symbol.XE, Symbol.RN, Symbol.OG -> 18
            else -> throw IllegalArgumentException("Group not defined for symbol: $symbol")
        }
    }
}
