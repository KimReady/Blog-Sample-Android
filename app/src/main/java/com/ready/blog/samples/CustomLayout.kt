package com.ready.blog.samples

import android.content.Context
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout

/**
 * Created by KimReady on 2020-05-09
 */
class CustomLayout(context: Context) : FrameLayout(context) {
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d("TouchEventTest", "called dispatchTouchEvent() in CustomLayout")
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.d("TouchEventTest", "called onInterceptTouchEvent() in CustomLayout")
//        return super.onInterceptTouchEvent(ev)
        return true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d("TouchEventTest", "called onTouchEvent() in CustomLayout")
        return super.onTouchEvent(event)
    }
}