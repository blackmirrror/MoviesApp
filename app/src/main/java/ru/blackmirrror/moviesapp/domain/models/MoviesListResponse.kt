package ru.blackmirrror.moviesapp.domain.models

import com.google.gson.annotations.SerializedName

data class MoviesListResponse(
    @SerializedName("total"      ) var total      : Int?             = null,
    @SerializedName("totalPages" ) var totalPages : Int?             = null,
    @SerializedName("items"      ) var items      : ArrayList<MovieResponse> = arrayListOf()
)