package com.labos.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var numberEditText: EditText
    private lateinit var actionSaveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        actionSaveButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name",nameEditText.text.toString())
            intent.putExtra("email",emailEditText.text.toString())
            intent.putExtra("number",numberEditText.text.toString())
            startActivity(intent)
        }
    }

    private fun bind() {
        nameEditText = findViewById(R.id.outlinedTextField)
        emailEditText = findViewById(R.id.outlinedTextField2)
        numberEditText = findViewById(R.id.outlinedTextField3)
        actionSaveButton = findViewById(R.id.btn_Save)
    }


}