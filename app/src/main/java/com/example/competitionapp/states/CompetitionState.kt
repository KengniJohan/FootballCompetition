package com.example.competitionapp.states

import com.example.competitionapp.data.models.Area
import com.example.competitionapp.data.models.Competition

sealed class CompetitionState {
    object Empty : CompetitionState()
    object Loading : CompetitionState()
    class Success(val data: List<Competition>) : CompetitionState()
    class Error(var message: String) : CompetitionState()
}