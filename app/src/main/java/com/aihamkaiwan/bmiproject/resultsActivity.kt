package com.example.bmiproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_results.*

class resultsActivity : AppCompatActivity() {


    lateinit var gender: String
    lateinit var heightCm: String
    lateinit var weightKg: String
    lateinit var ageInt: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)



        // The app returns 0 for all variables.

        val age = intent.getStringExtra("Extra_age").toString()
        val heightft = intent.getStringExtra("Extra_heightft").toString()
        val heightin = intent.getStringExtra("Extra_heightin").toString()
        val weight = intent.getStringExtra("Extra_weight").toString()


        gender = intent.getStringExtra("gender").toString()
        weightKg = (weight.toInt() * 0.45359237).toString()
        val heightintInches = ((heightft.toInt() * 12) + heightin.toInt())
        heightCm = (heightintInches * 2.54).toString()
        ageInt = age.toDouble().toString()



        // Toast.makeText(this, age.toString(), Toast.LENGTH_LONG).show()


        calcResults()


    }

    var result = 0.0


    /*

        Male: (88.4 + 13.4 x weight in kilograms) + (4.8 x height in centimeters) – (5.68 x age)
        Female: (447.6 + 9.25 x weight in kilograms) + (3.10 x height in centimeters) – (4.33 x age)

         */

    fun calcResults() {

        if (gender == "male") {
            result =
                //For men:
                    //BMR = 10W + 6.25H - 5A + 5
                    //For women:
                    //BMR = 10W + 6.25H - 5A - 161
                (10 * weightKg.toDouble()) + (6.25 * heightCm.toDouble()) - (5 * ageInt.toDouble())+5
        } else if (gender == "female") {
            result =
                (10 * weightKg.toDouble()) + (6.25 * heightCm.toDouble()) - (5 * ageInt.toDouble()-161)
        }

        var summary1 = "Summary: your body will burn "
        var summary2 = " calories per day."
        val finalsummary = summary1 + result.toInt().toString() + summary2
        finalResultsMessage.text =  finalsummary


    }
}