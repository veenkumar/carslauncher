package com.veen.cars.utils.api

import com.veen.cars.model.helpline.HelplingRes
import com.veen.cars.model.product.all.AllProductRes
import com.veen.cars.model.product.details.ProductDetailsReq
import com.veen.cars.model.product.details.ProductDetailsRes
import com.veen.cars.model.salesandservice.SalesServiceReq
import com.veen.cars.model.salesandservice.SalesServiceResponse
import com.veen.cars.utils.CommonFile.AllProductAPI
import com.veen.cars.utils.CommonFile.HelplineAPI
import com.veen.cars.utils.CommonFile.ProductDetailsAPI
import com.veen.cars.utils.CommonFile.SalesServiceAPI
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST

interface ApiInterface {
    @POST(SalesServiceAPI)
    suspend fun getSalesService(@Body salesServiceReq: SalesServiceReq): Response<SalesServiceResponse>

    @GET(AllProductAPI)
    suspend fun getAllProductList(): Response<AllProductRes>

//    @GET(ProductDetailsAPI)
    @HTTP(method = "POST", path = "product_detail.php", hasBody = true)
    fun getProductDetails(@Body productDetailsReq: ProductDetailsReq): Call<ProductDetailsRes>

    @GET(HelplineAPI)
    suspend fun getHelplineContact(): Response<HelplingRes>
}