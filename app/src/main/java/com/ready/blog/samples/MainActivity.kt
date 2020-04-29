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

        /* ViewModel 사용한 버전 */
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getInputText().observe(this, Observer<String> { newStr ->
            sample_text.text = newStr
        })

        ok_button.setOnClickListener {
            viewModel.updateText(edit_text.text.toString())
        }

        /* ViewModel 사용하지 않은 버전 */
//        ok_button.setOnClickListener {
//            sample_text.text = edit_text.text
//        }
    }
}
