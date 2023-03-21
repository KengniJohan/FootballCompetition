package com.example.competitionapp.data.models

data class CurrentSeason(
    var id : Int,
    var startDate : String,
    var endDate : String,
    var currentMatchday : Int,
)