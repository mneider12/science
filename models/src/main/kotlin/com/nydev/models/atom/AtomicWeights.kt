package com.nydev.models.atom

object AtomicWeights {
    private val weights = mapOf(
        Symbol.H to 1.008,
        Symbol.HE to 4.0026,
        Symbol.LI to 6.94,
        Symbol.BE to 9.0122,
        Symbol.B to 10.81,
        Symbol.C to 12.011,
        Symbol.N to 14.007,
        Symbol.O to 15.999,
        Symbol.F to 18.998,
        Symbol.NE to 20.180,
        Symbol.NA to 22.990,
        Symbol.MG to 24.305,
        Symbol.AL to 26.982,
        Symbol.SI to 28.085,
        Symbol.P to 30.974,
        Symbol.S to 32.06,
        Symbol.CL to 35.45,
        Symbol.K to 39.098,
        Symbol.AR to 39.948,
        Symbol.CA to 40.078,
        Symbol.SC to 44.956,
        Symbol.TI to 47.867,
        Symbol.V to 50.942,
        Symbol.CR to 51.996,
        Symbol.MN to 54.938,
        Symbol.FE to 55.845,
        Symbol.CO to 58.933,
        Symbol.NI to 58.693,
        Symbol.CU to 63.546,
        Symbol.ZN to 65.38,
        Symbol.GA to 69.723,
        Symbol.GE to 72.630,
        Symbol.AS to 74.922,
        Symbol.SE to 78.96,
        Symbol.BR to 79.904,
        Symbol.KR to 83.798,
        Symbol.RB to 85.468,
        Symbol.SR to 87.62,
        Symbol.Y to 88.906,
        Symbol.ZR to 91.224,
        Symbol.NB to 92.906,
        Symbol.MO to 95.95
    )

    fun get(symbol: Symbol): Double {
        return weights[symbol] ?: throw IllegalArgumentException("Weight not defined for symbol: $symbol")
    }
}
