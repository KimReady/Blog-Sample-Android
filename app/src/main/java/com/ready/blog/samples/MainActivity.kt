package com.ready.blog.samples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    private lateinit var noParamViewModel: NoParamViewModel
    private lateinit var hasParamViewModel: HasParamViewModel
    private lateinit var noParamAndroidViewModel: NoParamAndroidViewModel
    private lateinit var hasParamAndroidViewModel: HasParamAndroidViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* ViewModelProviders is deprecated */
//        noParamViewModel = ViewModelProviders.of(this).get(NoParamViewModel::class.java)

        /* use ViewModelProvider's constructor provided from lifecycle-extensions package */
        noParamViewModel = ViewModelProvider(this).get(NoParamViewModel::class.java)

        noParamViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(NoParamViewModel::class.java)

        noParamViewModel = ViewModelProvider(this, NoParamViewModelFactory())
            .get(NoParamViewModel::class.java)

        val sampleParam = "Ready Story"

        hasParamViewModel = ViewModelProvider(this, HasParamViewModelFactory(sampleParam))
            .get(HasParamViewModel::class.java)

        noParamAndroidViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
            .get(NoParamAndroidViewModel::class.java)

        hasParamAndroidViewModel = ViewModelProvider(this, HasParamAndroidViewModelFactory(application, sampleParam))
            .get(HasParamAndroidViewModel::class.java)
    }
}
