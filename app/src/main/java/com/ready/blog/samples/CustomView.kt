package com.ready.blog.samples

import android.content.Context
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView

/**
 * Created by KimReady on 2020-05-09
 */
class CustomView(context: Context) : AppCompatTextView(context) {
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d("TouchEventTest", "called dispatchTouchEvent() in CustomView")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d("TouchEventTest", "called onTouchEvent() in CustomView")
        return super.onTouchEvent(event)
    }
}