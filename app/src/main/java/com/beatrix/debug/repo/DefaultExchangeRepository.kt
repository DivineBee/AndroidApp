package com.beatrix.debug.repo;

import com.beatrix.debug.utils.CurrencyApi
import com.beatrix.debug.utils.CurrencyResponse
import com.beatrix.debug.utils.Resource
import javax.inject.Inject

class DefaultExchangeRepository @Inject constructor(
    private val api: CurrencyApi
) : ExchangeRepository {
    override suspend fun getRates(base: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(base)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occured")
        }
    }
}
