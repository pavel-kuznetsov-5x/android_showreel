package com.example.android_showreel.screens.multithreading

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_multithreading.*
import kotlinx.android.synthetic.main.content_multithreading.*


class MultithreadingActivity : AppCompatActivity() {
    val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.android_showreel.R.layout.activity_multithreading)
        setSupportActionBar(toolbar)

        rvNumbers.layoutManager = LinearLayoutManager(this)
        val primesAdapter = PrimeNumbersAdapter()
        rvNumbers.adapter = primesAdapter

        rbRx.isChecked = true
        rgSource.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                com.example.android_showreel.R.id.rbRx -> {
                }
            }
        }

//        disposables += .subscribe {
//            primesAdapter.add(it)
//            com.cucumber007.reusables.utils.logging.LogUtil.logDebug("Got", it)
//        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}
