package ru.blackmirrror.moviesapp.domain.models

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("kinopoiskId"      ) var kinopoiskId      : Int?                 = null,
    @SerializedName("imdbId"           ) var imdbId           : String?              = null,
    @SerializedName("nameRu"           ) var nameRu           : String?              = null,
    @SerializedName("nameEn"           ) var nameEn           : String?              = null,
    @SerializedName("nameOriginal"     ) var nameOriginal     : String?              = null,
    @SerializedName("countries"        ) var countries        : ArrayList<Countries> = arrayListOf(),
    @SerializedName("genres"           ) var genres           : ArrayList<Genres>    = arrayListOf(),
    @SerializedName("ratingKinopoisk"  ) var ratingKinopoisk  : Double?              = null,
    @SerializedName("ratingImdb"       ) var ratingImdb       : Double?              = null,
    @SerializedName("year"             ) var year             : Int?                 = null,
    @SerializedName("type"             ) var type             : String?              = null,
    @SerializedName("posterUrl"        ) var posterUrl        : String?              = null,
    @SerializedName("posterUrlPreview" ) var posterUrlPreview : String?              = null
)

data class Genres (
    @SerializedName("genre" ) var genre : String? = null
)

data class Countries (
    @SerializedName("country" ) var country : String? = null
)