package com.ready.blog.samples

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by KimReady on 2020-04-15
 */
class MainViewModel : ViewModel() {
    private var inputText: MutableLiveData<String> = MutableLiveData()

    fun getInputText() = inputText

    fun updateText(newText: String) {
        inputText.value = newText
    }
}