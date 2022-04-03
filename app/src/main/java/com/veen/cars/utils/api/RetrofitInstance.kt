package com.veen.cars.utils.api

import com.veen.cars.utils.CommonFile.BaseURL
import com.veen.cars.utils.CommonFile.CONNECT_TIMEOUT
import com.veen.cars.utils.CommonFile.READ_TIMEOUT
import com.veen.cars.utils.CommonFile.WRITE_TIMEOUT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    val instance: ApiInterface? = getapi()?.create(ApiInterface::class.java)

    private fun getapi(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(BaseURL)
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

        return okHttpClientBuilder
    }
}

