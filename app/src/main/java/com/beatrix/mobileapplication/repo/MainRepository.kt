package com.beatrix.debug.repo

import com.beatrix.debug.model.CurrencyResponse
import com.beatrix.debug.utils.Resource

interface MainRepository {
    suspend fun getRates(base: String): Resource<CurrencyResponse>
}