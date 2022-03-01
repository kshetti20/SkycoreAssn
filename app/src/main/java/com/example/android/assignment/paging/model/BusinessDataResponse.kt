package com.example.android.assignment.paging.model

import com.google.gson.annotations.SerializedName

data class BusinessDataResponse(
    @SerializedName("businesses") val items: List<BusinessData> = emptyList(),
)
