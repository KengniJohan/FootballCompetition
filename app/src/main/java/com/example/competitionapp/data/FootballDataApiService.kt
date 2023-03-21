package com.example.competitionapp.data

import com.example.competitionapp.data.models.Area
import com.example.competitionapp.data.models.Competitions
import com.example.competitionapp.utils.GET_AREA_FEATURES
import com.example.competitionapp.utils.GET_COMPETION_FEATURES
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballDataApiService {

    @GET(GET_COMPETION_FEATURES)
    suspend fun getCompetitions() : Competitions

    @GET(GET_AREA_FEATURES)
    suspend fun getAreas() : List<Area>

    @GET(GET_AREA_FEATURES)
    suspend fun getAreaById(@Query("q") id : Int) : List<Area>

}