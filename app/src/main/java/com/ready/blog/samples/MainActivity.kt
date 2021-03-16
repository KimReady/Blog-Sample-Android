package com.ready.blog.samples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    val LOG_TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateTo(FirstFragment())
    }

    fun navigateTo(fragment: Fragment) {
        Log.d(LOG_TAG, "add() - ${fragment.javaClass.simpleName}")
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, fragment)           // 1. add
//            .replace(R.id.fragment_container_view, fragment)     // 2. replace
//            .addToBackStack(null)                           // 3. addToBackStack
            .commit()
    }
}
