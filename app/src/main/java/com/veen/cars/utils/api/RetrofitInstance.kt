package com.veen.cars.utils.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    private val BaseUrl = "http://192.168.0.108:8000/api/"
    private val CONNECT_TIMEOUT = 60
    private val READ_TIMEOUT = 60
    private val WRITE_TIMEOUT = 60

    val instance: ApiInterface? = getapi()?.create(ApiInterface::class.java)

    private fun getapi(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkhttpClientBuilder().build())
            .build()
    }

    private fun getOkhttpClientBuilder(): OkHttpClient.Builder {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
        okHttpClientBuilder.writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)

        okHttpClientBuilder.addInterceptor(loggingInterceptor)

/*        okHttpClientBuilder.addInterceptor{ chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization:", token)
                .build()
            chain.proceed(newRequest)
        }*/

        return okHttpClientBuilder
    }
}

