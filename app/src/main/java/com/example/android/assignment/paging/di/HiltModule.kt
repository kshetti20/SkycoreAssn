package com.example.android.assignment.paging.di

import com.example.android.assignment.paging.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    private const val BASE_URL = "https://api.yelp.com/v3/businesses/"

    @Singleton
    @Provides
    fun getInstance() = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun getRetrofitInstance(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

}