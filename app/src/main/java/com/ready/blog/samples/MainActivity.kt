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
            result_text.text = when (radio_group.checkedRadioButtonId) {
                R.id.radio_circle -> viewModel.areaOfCircle.value!!.toString()
                R.id.radio_square -> viewModel.areaOfSquare.value!!.toString()
                else -> throw IllegalArgumentException()
            }
        }

        radio_group.check(R.id.radio_circle)
    }
}
