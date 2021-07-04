package com.ready.blog.samples

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web_view.loadUrl("https://readystory.tistory.com")

        move_top.setOnClickListener {
            web_view.pageUp(true)
        }

        move_bottom.setOnClickListener {
            web_view.pageDown(true)
        }

        page_up.setOnClickListener {
            web_view.pageUp(false)
        }

        page_down.setOnClickListener {
            web_view.pageDown(false)
        }

        always_mode.setOnClickListener {
            web_view.overScrollMode = WebView.OVER_SCROLL_ALWAYS
        }

        if_contents_mode.setOnClickListener {
            web_view.overScrollMode = WebView.OVER_SCROLL_IF_CONTENT_SCROLLS
        }

        never_mode.setOnClickListener {
            web_view.overScrollMode = WebView.OVER_SCROLL_NEVER
        }
    }
}
