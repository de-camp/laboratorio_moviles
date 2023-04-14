package com.labos.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var nameM2TextView: TextView
    private lateinit var emailM2TextView: TextView
    private lateinit var numberM2TextView: TextView
    private lateinit var actionShareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        bind()
        fillInfo()
        actionShareButton.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Name: ${nameM2TextView.text}\nEmail: ${emailM2TextView.text}\n" +
                        "Phone: ${numberM2TextView.text}")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

    }

    private fun bind() {
        nameM2TextView = findViewById(R.id.nameMain2)
        emailM2TextView = findViewById(R.id.emailMain2)
        numberM2TextView = findViewById(R.id.numberMain2)
        actionShareButton = findViewById(R.id.btn_Share)
    }

    private fun fillInfo() {
        val key0 = intent.getStringExtra("name").toString()
        val key1 = intent.getStringExtra("email").toString()
        val key2 = intent.getStringExtra("number").toString()

        nameM2TextView.text = key0
        emailM2TextView.text = key1
        numberM2TextView.text = key2
    }
}