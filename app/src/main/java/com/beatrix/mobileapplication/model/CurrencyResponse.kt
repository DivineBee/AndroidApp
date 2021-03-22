package com.beatrix.debug.model

data class CurrencyResponse(
    val base: String,
    val date: String,
    val rates: Rates
)