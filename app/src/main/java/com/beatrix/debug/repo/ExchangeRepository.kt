package com.beatrix.debug.repo

import com.beatrix.debug.utils.CurrencyResponse
import com.beatrix.debug.utils.Resource

interface ExchangeRepository {
    suspend fun getRates(base: String): Resource<CurrencyResponse>
}