package com.example.bmiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmi_results.*

class BMIResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_results)



        calcBMI()
    }


    // weight (lb) / [height (in)]^2 x 703
    private fun calcBMI() {
        val heightft = intent.getStringExtra("Extra_bmi_heightft").toString()
        val heightin = intent.getStringExtra("Extra_bmi_heightin").toString()
        val weight = intent.getStringExtra("Extra_bmi_weight").toString()
        val heightInches = (heightft.toInt() * 12) + heightin.toInt()

        var bmiEquation = (703*(weight.toFloat() / (heightInches * heightInches)))
        val bmi = bmiEquation.toDouble()
        bmiEquation = "%.2f".format(bmiEquation).toDouble().toFloat()
        fun healthyOrNot(answer:Double): String {
            if(bmi < 18.5){
                return "underweight."
            }else if(bmi in 18.5..24.9){
                return "healthy weight!"
            }else if(bmi in 25.0..29.9){
                return "overweight."
            }else{
                return "obese"
            }
        }
        val summary = "Your BMI is $bmiEquation, indicating that you are ${healthyOrNot(bmi)}"
        textView_bmi_resultNum.text = summary
    }
}