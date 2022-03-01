package com.example.android.assignment.paging.model

import com.google.gson.annotations.SerializedName

data class BusinesLocation(
    @field:SerializedName("address1") val address1: String,
    @field:SerializedName("city") val city: String,
    @field:SerializedName("zip_code") val zip_code: String,
)
