package com.ready.blog.samples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

        ok_button.setOnClickListener {
            viewModel.updateText(edit_text.text.toString().toInt())
        }

        viewModel.areaOfCircle.observe(this, Observer<Double> { area ->
            circle_area_text.text = "원 넓이 : $area"
        })

        viewModel.areaOfSquare.observe(this, Observer<Int> { area ->
            square_area_text.text = "정사각형 넓이 : $area"
        })
    }
}
