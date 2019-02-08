package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        val val0: String = "This is val0"
        val val1: String = "This is val1"

        buttonSub0.setOnClickListener {
            startActivity<Sub0Activity>(
                "val0" to val0,
                "val1" to val1
            )
        }

        buttonSub1.setOnClickListener {
            startActivity<Sub1Activity>()
        }

        buttonSave.setOnClickListener {
            saveData(editText.text.toString())
        }

    }

    private fun saveData(text: String) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putString("KEY_TEXT", text)
            .apply()
    }

    private fun loadData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val text = pref.getString("KEY_TEXT", "text")

        if (text != null) {
            editText.setText(text)
        }
    }

}
