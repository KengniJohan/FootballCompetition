package com.example.competitionapp.data.models

data class Area(
    var id : Int,
    var name : String,
    var countryCode : String,
    var flag : String?,
    var parentAreaId : Int?
)
