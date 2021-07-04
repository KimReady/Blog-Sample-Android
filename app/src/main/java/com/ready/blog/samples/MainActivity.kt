package com.ready.blog.samples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customLayout = CustomLayout(this)
        addContentView(customLayout, FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT))

        val customView = CustomView(this)
        customView.text = "Hello, Ready Story!"
        customLayout.addView(customView)
    }
}
