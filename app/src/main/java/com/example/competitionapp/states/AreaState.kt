package com.example.competitionapp.states

import com.example.competitionapp.data.models.Area

sealed class AreaState{
    object Empty : AreaState()
    object Loading : AreaState()
    class Success(val data: List<Area>) : AreaState()
    class Error(var message: String) : AreaState()

}
