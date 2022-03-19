package com.veen.cars.utils.api

import com.veen.cars.model.salesandservice.SalesServiceResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("queries-items/")
    suspend fun getSalesService(): Response<SalesServiceResponse>
}