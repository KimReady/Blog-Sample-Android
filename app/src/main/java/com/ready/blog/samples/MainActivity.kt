package com.ready.blog.samples

import android.os.Bundle
import android.os.Handler
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web_view.run {
            webViewClient = CustomWebViewClient(::writeLog)
            loadUrl("https://readystory.tistory.com/")
        }
        log_text.movementMethod = ScrollingMovementMethod()
    }

    private fun writeLog(log: String) {
        handler.post {
            log_text.append(log)
        }
    }
}
