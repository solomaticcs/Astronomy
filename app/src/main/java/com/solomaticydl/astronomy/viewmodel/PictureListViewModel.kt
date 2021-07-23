package com.solomaticydl.astronomy.viewmodel

import androidx.lifecycle.*
import com.solomaticydl.astronomy.model.AstronomyModel
import com.solomaticydl.astronomy.repository.PictureListRepository
import com.solomaticydl.astronomy.state.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PictureListViewModel(
    private val pictureListRepository: PictureListRepository = PictureListRepository()
) : ViewModel() {

    private val _resultLiveData = MutableLiveData<UiState<List<AstronomyModel>>>()
    val resultLiveData: LiveData<UiState<List<AstronomyModel>>>
        get() = _resultLiveData

    @ExperimentalCoroutinesApi
    fun requestAstronomyData() {
        viewModelScope.launch {
            _resultLiveData.value = UiState.InProgress
            try {
                val dataList = withContext(Dispatchers.IO) {
                    pictureListRepository.getAstronomyData()
                }
                _resultLiveData.value = UiState.Success(dataList)
            } catch (e: Throwable) {
                _resultLiveData.value = UiState.Error(e)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        pictureListRepository.cancel()
    }
}