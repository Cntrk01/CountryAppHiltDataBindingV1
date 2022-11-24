package com.example.countryapphilt.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countryapphilt.model.DataList
import com.example.countryapphilt.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject
constructor(private val homeRepository: HomeRepository):ViewModel() {
     var data:MutableLiveData<List<DataList>> =MutableLiveData()
     var progresBar:MutableLiveData<Boolean> = MutableLiveData(true)
     var errorMessage:MutableLiveData<Boolean> = MutableLiveData()

    init {
        getDataApi()
    }

   private fun getDataApi() = viewModelScope.launch {
       progresBar.value= true
       homeRepository.getData().let{
            if(it.isSuccessful){
                data.postValue(it.body())
                progresBar.value=false
                errorMessage.value=false
            }else{
                progresBar.value=false
                errorMessage.value=true
                Log.d("tag","Error : ${it.message()}")
            }
       }
    }

}