package com.example.competitionapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.competitionapp.repositories.CompetitionRepository
import com.example.competitionapp.states.AreaState
import com.example.competitionapp.states.CompetitionState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class CompetitionViewModel @Inject constructor(private val competitionRepository: CompetitionRepository) : ViewModel() {

    private val _competitionState = MutableStateFlow<CompetitionState>(CompetitionState.Empty)
    val competitionState: StateFlow<CompetitionState> = _competitionState

    init {
        getAllCompetitions()
    }

    private fun getAllCompetitions() {

        _competitionState.value = CompetitionState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            try{
                val competitionResponse = competitionRepository.getCompetitions()
                _competitionState.value = CompetitionState.Success(competitionResponse)
            } catch(exception : HttpException) {
                _competitionState.value = CompetitionState.Error("No internet connection")
            } catch (exception: IOException){
                _competitionState.value = CompetitionState.Error("Something went wrong")
            }

        }
    }

}