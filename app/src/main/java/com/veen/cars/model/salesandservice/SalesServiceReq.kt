package com.veen.cars.model.salesandservice

data class SalesServiceReq(
    val address: String,
    val company_name: String,
    val contact_no: String,
    val email: String,
    val name: String,
    val query: String,
    val sale_or_service: String
)