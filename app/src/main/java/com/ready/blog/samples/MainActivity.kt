package com.ready.blog.samples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ToolBar를 ActionBar로 설정해줘야 합니다.
        setSupportActionBar(app_toolbar)

        // 리사이클러뷰의 데이터는 1~50 숫자로 설정합니다.
        val dataSet = (1..50).toList()
        bible_recycler_view.adapter = SampleAdapter(dataSet)
    }
}
