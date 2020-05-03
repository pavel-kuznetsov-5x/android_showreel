package com.example.android_showreel.screens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_showreel.R
import com.example.android_showreel.screens.multithreading.MultithreadingActivity
import kotlinx.android.synthetic.main.activity_async.*
import kotlinx.android.synthetic.main.content_async.*

class AsyncActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)
        setSupportActionBar(toolbar)

//        todo description

        bMultithreading.setOnClickListener {
            startActivity(Intent(this, MultithreadingActivity::class.java))
        }

    }

}
