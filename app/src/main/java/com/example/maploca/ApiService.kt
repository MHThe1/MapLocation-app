package com.example.maploca

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder().baseUrl("https://labs.anontech.info/cse489/t3/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val mapLocaService = retrofit.create(ApiService::class.java)

interface ApiService {
    @GET("api.php")
    suspend fun getMapEntriesData(): MapEntriesResponse
}
