package com.example.android.assignment.paging.api

import com.example.android.assignment.paging.model.BusinessDataResponse

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun searchBusinesses(
        @Header("Authorization") api_key: String,
        @Query("location") location: String,
        @Query("radius") radius: String,
        @Query("term") term: String = "restaurents",
        @Query("sort_by") sort_by: String = "distance",
        @Query("limit") limit: String = "15",
        @Query("offset") offset: String = "0"
        ): BusinessDataResponse

}
