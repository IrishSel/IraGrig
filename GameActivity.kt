package com.example.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.TextureView
import android.view.View
import android.widget.TextView

class GameActivity : AppCompatActivity() {
    var begin: Int = 0
    var end: Int = 100
    var mean: Int = 0
    lateinit var tvQuestion: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        begin = intent.getIntExtra("begin", 0)
        end = intent.getIntExtra("end", 100)
        tvQuestion = findViewById<TextView>(R.id.question)

        if(end - begin == 1){
            tvQuestion.text = "Ваше число равно " + begin + "?"
        }
        else{
            mean = begin + (end - begin)/2
            tvQuestion.text = "Ваше число больше или равно " + mean + "?"
        }
//        Log.d("mytag", "begin = " + begin)
//        Log.d("mytag", "end = " + end)
    }

    fun onYesNoClick(view: View) {
        if(end - begin > 1){
            when (view.id) {
                R.id.yes -> {
                    begin = mean
                    mean = (end - begin)/2 + begin
                    tvQuestion.text = "Ваше число больше или равно " + mean + "?"
                }
                R.id.no -> {
                    end = mean
                    mean = (end - begin)/2 + begin
                    tvQuestion.text = "Ваше число больше или равно " + mean + "?"
                }
            }
        }
        else{
            when (view.id) {
                R.id.yes -> {
                    tvQuestion.text = "Ваше число равно " + begin
                }
                R.id.no -> {
                    tvQuestion.text = "Ваше число равно " + end
                }
            }
        }
    }


}