package me.darthwithap.flatsounds.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import me.darthwithap.flatsounds.data.CategoryRepo

class HomeViewModel : ViewModel() {
  private var _categoryList: MutableLiveData<List<String>> = MutableLiveData()
  val categoryList: LiveData<List<String>> = _categoryList

  fun updateCategoryList(): Job {
    return viewModelScope.launch {
      CategoryRepo.getCategoryList()?.let {
        _categoryList.postValue(it)
      }
    }
  }
}