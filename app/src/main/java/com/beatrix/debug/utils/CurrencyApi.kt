package com.beatrix.debug.utils

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "dd611a69b0c59566e325de46673a1c23"

interface CurrencyApi {
    @GET("/v1/latest?access_key=dd611a69b0c59566e325de46673a1c23")
    suspend fun getRates(
        @Query("base") base: String
    ): Response<CurrencyResponse>

}