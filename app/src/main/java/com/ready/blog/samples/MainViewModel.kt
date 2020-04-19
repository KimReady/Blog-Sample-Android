package com.ready.blog.samples

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlin.math.PI

/**
 * Created by KimReady on 2020-04-15
 */
class MainViewModel : ViewModel() {
    val widthText: MutableLiveData<Int> = MutableLiveData()
    val areaOfSquare: LiveData<Int> = Transformations.map(widthText) {
        it * it
    }
    val areaOfCircle: LiveData<Double> = Transformations.switchMap(widthText) { width ->
        getAreaOfCircle(width)
    }

    fun updateText(newWidth: Int) {
        widthText.value = newWidth
    }

    private fun getAreaOfCircle(width: Int): LiveData<Double> {
        val liveData: MutableLiveData<Double> = MutableLiveData()
        liveData.run {
            value = width * width * PI
        }
        return liveData
    }
}