package com.example.competitionapp.data.models

data class Competition(
    var id : Int,
    var area: Area,
    var name : String,
    var currentSeason: CurrentSeason,
    var numberOfAvailableSeasons : Int
)
