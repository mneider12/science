package com.nydev.data.periodictable

import com.nydev.models.atom.Symbol

class Period {
    fun get(symbol: Symbol): Int {
        return when (symbol) {
            Symbol.H, Symbol.HE -> 1
            
            Symbol.LI, Symbol.BE, Symbol.B, Symbol.C, Symbol.N, Symbol.O, Symbol.F, Symbol.NE -> 2
            
            Symbol.NA, Symbol.MG, Symbol.AL, Symbol.SI, Symbol.P, Symbol.S, Symbol.CL, Symbol.AR -> 3
            
            Symbol.K, Symbol.CA, Symbol.SC, Symbol.TI, Symbol.V, Symbol.CR, Symbol.MN, Symbol.FE, 
            Symbol.CO, Symbol.NI, Symbol.CU, Symbol.ZN, Symbol.GA, Symbol.GE, Symbol.AS, Symbol.SE, 
            Symbol.BR, Symbol.KR -> 4
            
            Symbol.RB, Symbol.SR, Symbol.Y, Symbol.ZR, Symbol.NB, Symbol.MO, Symbol.TC, Symbol.RU, 
            Symbol.RH, Symbol.PD, Symbol.AG, Symbol.CD, Symbol.IN, Symbol.SN, Symbol.SB, Symbol.TE, 
            Symbol.I, Symbol.XE -> 5
            
            Symbol.CS, Symbol.BA, Symbol.LA, Symbol.CE, Symbol.PR, Symbol.ND, Symbol.PM, Symbol.SM, 
            Symbol.EU, Symbol.GD, Symbol.TB, Symbol.DY, Symbol.HO, Symbol.ER, Symbol.TM, Symbol.YB, 
            Symbol.LU, Symbol.HF, Symbol.TA, Symbol.W, Symbol.RE, Symbol.OS, Symbol.IR, Symbol.PT, 
            Symbol.AU, Symbol.HG, Symbol.TL, Symbol.PB, Symbol.BI, Symbol.PO, Symbol.AT, Symbol.RN -> 6
            
            Symbol.FR, Symbol.RA, Symbol.AC, Symbol.TH, Symbol.PA, Symbol.U, Symbol.NP, Symbol.PU, 
            Symbol.AM, Symbol.CM, Symbol.BK, Symbol.CF, Symbol.ES, Symbol.FM, Symbol.MD, Symbol.NO, 
            Symbol.LR, Symbol.RF, Symbol.DB, Symbol.SG, Symbol.BH, Symbol.HS, Symbol.MT, Symbol.DS, 
            Symbol.RG, Symbol.CN, Symbol.NH, Symbol.FL, Symbol.MC, Symbol.LV, Symbol.TS, Symbol.OG -> 7
            
            else -> throw IllegalArgumentException("Period not defined for symbol: $symbol")
        }
    }
}
