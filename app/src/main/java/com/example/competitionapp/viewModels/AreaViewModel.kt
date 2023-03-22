package com.example.competitionapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.competitionapp.repositories.AreaRepository
import com.example.competitionapp.states.AreaState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject


class AreaViewModel @Inject constructor(private val areaRepository: AreaRepository) : ViewModel(){

    private val _areaState = MutableStateFlow<AreaState>(AreaState.Empty)
    private val areaState: StateFlow<AreaState> = _areaState


    fun getAllAreas() {

        _areaState.value = AreaState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            try{
                val areaResponse = areaRepository.getAreas()
                _areaState.value = AreaState.Success(areaResponse)
            } catch(exception : HttpException) {
                _areaState.value = AreaState.Error("No internet connection")
            } catch (exception: IOException){
                _areaState.value = AreaState.Error("Something went wrong")
            }

        }
    }

    fun getAreaById(id : Int) {

        _areaState.value = AreaState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            try{
                val areaResponse = areaRepository.getAreaById(id)
                _areaState.value = AreaState.Success(areaResponse)
            } catch(exception : HttpException) {
                _areaState.value = AreaState.Error("No internet connection")
            } catch (exception: IOException){
                _areaState.value = AreaState.Error("Something went wrong")
            }

        }

    }

}