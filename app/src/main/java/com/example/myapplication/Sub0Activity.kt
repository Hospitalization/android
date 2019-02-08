package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub0.*
import kotlin.concurrent.timer

class Sub0Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub0)

        val val0 = intent.getStringExtra("val0").toString()
        val val1 = intent.getStringExtra("val1").toString()

        textViewSub0.text = val0
        textViewSub1.text = val1

        var sec = 0
        timer(period=1000){
            sec++
            runOnUiThread {
                textViewTimer.text = "$sec"
            }
        }
    }
}
