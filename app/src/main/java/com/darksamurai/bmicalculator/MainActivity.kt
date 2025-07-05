package com.darksamurai.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val userName : EditText = findViewById(R.id.name)
        val age : EditText = findViewById(R.id.age)
        val weight : EditText = findViewById(R.id.weight)
        val height : EditText = findViewById(R.id.height)
        val btn : Button = findViewById(R.id.submit)
        btn.setOnClickListener {
            val weightValue = weight.text.toString().toFloatOrNull()
            val heightValue = height.text.toString().toFloatOrNull()

            if (weightValue == null || heightValue == null || heightValue == 0f) {
                Toast.makeText(this, "Please enter valid weight and height.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val heightInMeters = heightValue / 100
            val BMI: Float = weightValue / (heightInMeters * heightInMeters)

            val msg = when {
                BMI < 16.0 -> "You're *Severely* Underweight."
                BMI in 16.0..16.9 -> "You're *Moderately* Underweight."
                BMI in 17.0..18.4 -> "You're *Mildly* Underweight."
                BMI in 18.5..24.9 -> "You're *Normal*."
                else -> "You're *Overweight*."
            }

            Toast.makeText(this, "Your BMI is: %.2f.\n%s".format(BMI, msg), Toast.LENGTH_SHORT).show()
        }

    }
}