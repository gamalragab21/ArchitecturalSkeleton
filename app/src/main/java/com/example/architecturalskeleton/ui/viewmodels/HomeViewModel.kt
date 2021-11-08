package com.example.architecturalskeleton.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architecturalskeleton.qualifiers.MainThread
import com.example.architecturalskeleton.repositiories.DefaultHomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val repository: DefaultHomeRepository,
    @MainThread
    private val dispatcher: CoroutineDispatcher

): ViewModel() {

    // TODO: 11/8/2021 Simple way to show how to handle repo with view model by using livedata
//    private val _listJobStatus= MutableLiveData<Event<Resource<ParentJob>>>()
//    val listJobStatus: LiveData<Event<Resource<ParentJob>>> =_listJobStatus

//    fun  getAllJobs(currentJob: Int) {
//
//        _listJobStatus.postValue(Event(Resource.Loading()))
//
//        viewModelScope.launch(dispatcher) {
//            val result=repository.getListJob(currentJob)
//            _listJobStatus.postValue(Event(result))
//        }
//
//    }

}