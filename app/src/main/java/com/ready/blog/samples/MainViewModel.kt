package com.ready.blog.samples

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by KimReady on 2020-09-20
 */
class MainViewModel : ViewModel() {
    private val _openEvent = MutableLiveData<Event<String>>()
    val openEvent: LiveData<Event<String>> get() = _openEvent

    val sampleText: MutableLiveData<String> = MutableLiveData()

    fun onClickEvent(text: String) {
        _openEvent.value = Event(text)
    }
}