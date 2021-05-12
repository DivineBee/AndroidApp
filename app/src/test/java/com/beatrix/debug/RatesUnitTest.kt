package com.beatrix.debug

import com.beatrix.debug.models.Rates
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class RatesUnitTest {
    private val DELTA = 1e-15
    lateinit var rates: Rates

    @Before
    fun setUp(){
        rates = Rates(
            34.6, 32.3, 12.4, 21.4, 12.6, 12.7, 74.45,
            234.54, 38.4, 18.65, 76.48, 35.8, 86.422, 98.34, 23.65,
            38.68, 77.457, 45.98, 56.87, 31.4, 4.6, 12.44, 11.76,
            123.6, 76.6, 17.45, 13.56, 234.34, 24.56, 76.45, 34.88,
            34.67, 87.87
        )
    }

    @Test
    fun getValidRates(){
        assertEquals(rates.aUD, 34.6, DELTA)
        assertEquals(rates.rON, 17.45, DELTA)
        assertEquals(rates.uSD, 34.67, DELTA)
    }
}