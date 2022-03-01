package com.example.android.assignment.paging.model

import com.google.gson.annotations.SerializedName

data class BusinessData(
    @field:SerializedName("id") val id: String,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("image_url") val image_url: String,
    @field:SerializedName("is_closed") val is_closed: Boolean,
    @field:SerializedName("distance") val distance: Double,
    @field:SerializedName("rating") val rating: Double,
    @field:SerializedName("location") val location: BusinesLocation
)
