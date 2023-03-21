package com.example.competitionapp.repositories

import com.example.competitionapp.data.FootballDataApiService
import com.example.competitionapp.data.models.Area
import javax.inject.Inject

class AreaRepository @Inject constructor(private val footballDataApiService: FootballDataApiService) {

    suspend fun getAreas() : List<Area> = footballDataApiService.getAreas()

    suspend fun getAreaById(id : Int) : List<Area> = footballDataApiService.getAreaById(id)


}