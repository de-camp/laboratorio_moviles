package com.example.laboratorio_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.bind
import android.widget.AbsListView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var  actionSentButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var weightClass: TextView
    private lateinit var legend: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind();

        actionSentButton.setOnClickListener{
            var weight = weightEditText.text.toString()
            var height = heightEditText.text.toString()

            if (validateInput(weight,height)){
                var result = calculateBMI(weight.toFloat(), height.toFloat())

                if (result < 18.5) {
                    resultTextView.text = result.toString();
                    weightClass.text = "Underweight"
                    weightClass.setTextColor(getColor(R.color.under_weight))
                    legend.text = "Be careful! You're underweight"

                } else if (result >= 18.5 && result <= 24.99) {
                    resultTextView.text = result.toString();
                    weightClass.text = "Healthy"
                    weightClass.setTextColor(getColor(R.color.normal_weight))
                    legend.text = "Normal range is between 18.5 and 24.99"

                } else if (result >= 25 && result <= 29.99){
                    resultTextView.text = result.toString()
                    weightClass.text = "Overweight"
                    weightClass.setTextColor(getColor(R.color.over_weight))
                    legend.text = "Be careful with what you eat"

                } else {
                    resultTextView.text = result.toString();
                    weightClass.text = "Obese"
                    weightClass.setTextColor(getColor(R.color.obese))
                    legend.text = "You might consider to visit a doctor"

                }

            }
        }
    }

    private fun bind() {
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        actionSentButton = findViewById(R.id.action_sent_button)
        resultTextView = findViewById(R.id.result_text_view)
        weightClass = findViewById(R.id.weight_class_text_view)
        legend = findViewById(R.id.range_text_view)

    }



    private fun calculateBMI(weight: Float, height: Float): Float {
        return weight / ((height/100)*(height/100))
    }

    private fun validateInput( weight: String?, height: String?): Boolean {
        return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty", Toast.LENGTH_SHORT).show()
                return false;
            }

            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_SHORT).show()
                return false;
            }
            else -> true
        }
    }


}
