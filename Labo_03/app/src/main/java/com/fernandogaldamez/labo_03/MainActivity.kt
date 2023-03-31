package com.fernandogaldamez.labo_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.bind
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var counterTextView : TextView
    private lateinit var fiveImageView: ImageView
    private lateinit var tenImageView: ImageView
    private lateinit var quaterImageView: ImageView
    private lateinit var oneImageView: ImageView
    public var contadorText : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind();



        fiveImageView.setOnClickListener{
            var sumaCinco: Float = 0.05f
            updaterCounter(sumaCinco)

        }

        tenImageView.setOnClickListener{
            var sumaDiez: Float = 0.10f
            updaterCounter(sumaDiez)
        }

        quaterImageView.setOnClickListener{
            var sumaCora: Float = 0.25f
            updaterCounter(sumaCora)
        }

        oneImageView.setOnClickListener{
            var sumaDolar: Float = 1.00f
            updaterCounter(sumaDolar)
        }

    }

    private fun bind() {
        counterTextView = findViewById(R.id.contador_textView)
        fiveImageView = findViewById(R.id.five_imageView)
        tenImageView = findViewById(R.id.ten_imageView2)
        quaterImageView = findViewById(R.id.quarter_imageView4)
        oneImageView = findViewById(R.id.one_imageView5)

    }

    private fun updaterCounter(sumando: Float) {
        contadorText = contadorText + sumando
        contadorText = (contadorText * 100.0).roundToInt()/100.0
        counterTextView.text = contadorText.toString()
    }
}