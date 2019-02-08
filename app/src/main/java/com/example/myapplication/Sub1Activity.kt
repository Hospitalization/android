package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sub1.*

class Sub1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub1)

        buttonTouch.setOnTouchListener { v: View, m: MotionEvent ->
            handleTouch(m)
            true
        }
    }

    private fun handleTouch(m: MotionEvent) {
        val pointerCount = m.pointerCount

        for (i in 0 until pointerCount) {
            val x = m.getX(i)
            val y = m.getY(i)
            val id = m.getPointerId(i)
            val action = m.actionMasked
            val actionIndex = m.actionIndex
            var actionString: String

            actionString = when (action) {
                MotionEvent.ACTION_DOWN -> "DOWN"
                MotionEvent.ACTION_UP -> "UP"
                MotionEvent.ACTION_POINTER_DOWN -> "PNTR DOWN"
                MotionEvent.ACTION_POINTER_UP -> "PNTR UP"
                MotionEvent.ACTION_MOVE -> "MOVE"
                else -> ""
            }

            val touchStatus =
                "Action: $actionString Index: $actionIndex ID: $id X: $x Y: $y"

            if (id == 0)
                textViewSub1_0.text = touchStatus
            else
                textViewSub1_1.text = touchStatus
        }
    }
}
