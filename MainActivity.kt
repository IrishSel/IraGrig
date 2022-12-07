package com.example.guessnumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onGuessClick(view: View) {

        val begin2 = findViewById<EditText>(R.id.begin)
        val end2 = findViewById<EditText>(R.id.end)

        val begin = begin2.text.toString().toInt()
        val end = end2.text.toString().toInt()

        val intent = Intent(this, GameActivity::class.java) //с одного окна передает данные в другое
        intent.putExtra("begin", begin)
        intent.putExtra("end", end)
        startActivity(intent)

    }
}