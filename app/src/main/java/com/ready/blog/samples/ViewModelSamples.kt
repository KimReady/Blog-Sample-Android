package com.ready.blog.samples

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

/**
 * Created on 15/04/2020
 *
 * @author junbi.kim (junbi.kim@navercorp.com)
 */
class NoParamViewModel : ViewModel()

class HasParamViewModel(val param: String) : ViewModel()

class NoParamAndroidViewModel(application: Application) : AndroidViewModel(application)

class HasParamAndroidViewModel(application: Application, val param: String)
    : AndroidViewModel(application)