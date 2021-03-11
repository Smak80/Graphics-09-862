package ru.smak.graphics_09_862.ui.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val boolData = MutableLiveData<Boolean>()

    var boolValue: Boolean
        get() = boolData.value ?: false
        set(value) {
            boolData.value = value
        }

    fun setOnDataChangedListener(owner: LifecycleOwner, f: (Boolean)->Unit){
        boolData.observe(owner, f)
    }
}