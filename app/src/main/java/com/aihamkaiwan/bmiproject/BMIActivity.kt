package com.example.bmiproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bmractivity.*
import kotlinx.android.synthetic.main.bmi_activity_re.*

class BMIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_activity_re)


        button_reset_bmi.setOnClickListener(View.OnClickListener {
            tiEditText_bmi_heightft.text = null
            tiEditText_bmi_heightinc.text = null
            tiEditText_bmi_weight.text = null
        })

        button_calculate_bmi.setOnClickListener(View.OnClickListener {


            if(tiEditText_bmi_heightft.text.isNullOrEmpty() || tiEditText_bmi_heightinc.text.isNullOrEmpty() || tiEditText_bmi_weight.text.isNullOrEmpty()){
                Toast.makeText(this, "Please complete the information!", Toast.LENGTH_SHORT).show()
            }else{
                intentResultbmi()
            }

        })



    }



    private fun intentResultbmi(){
        val heightbmift = tiEditText_bmi_heightft.text.toString()
        val heightbmiin = tiEditText_bmi_heightinc.text.toString()
        val weightbmilb = tiEditText_bmi_weight.text.toString()

        Intent(this, BMIResult::class.java).also {
            it.putExtra("Extra_bmi_heightft", heightbmift)
            it.putExtra("Extra_bmi_heightin", heightbmiin)
            it.putExtra("Extra_bmi_weight", weightbmilb)
            startActivity(it)
        }
    }
}