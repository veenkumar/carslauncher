package com.veen.cars.model.helpline

data class HelplingRes(
    val flag: Int,
    val message: String,
    val result: List<Result>
)