package com.example.competitionapp.repositories

import com.example.competitionapp.data.FootballDataApiService
import com.example.competitionapp.data.models.Competition
import com.example.competitionapp.data.models.Competitions
import javax.inject.Inject

class CompetitionRepository @Inject constructor(private val footballDataApiService: FootballDataApiService) {

    suspend fun getCompetitions() : List<Competition> = footballDataApiService.getCompetitions().data

}