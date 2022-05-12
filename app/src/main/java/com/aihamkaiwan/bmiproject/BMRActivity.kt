package com.example.bmiproject

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bmractivity.*

class BMRActivity : AppCompatActivity() {


    var defaultGender = "male"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmractivity)


        button_calculate.setOnClickListener(View.OnClickListener {



            if(tiEditText_age.text.isNullOrEmpty() || tiEditText_height_feet.text.isNullOrEmpty() || tiEditText_height_inches.text.isNullOrEmpty() || tiEditText_weight.text.isNullOrEmpty()){
                Toast.makeText(this, "Please complete the information!", Toast.LENGTH_SHORT).show()
            }else{
                intentResult()
            }



        })

        cardview_male.setOnClickListener(View.OnClickListener {
            changebackgroundColor1()
            defaultGender = "male"


        })

        cardview_female.setOnClickListener(View.OnClickListener {
            changebackgroundColor2()
            defaultGender = "female"
        })
        button_reset.setOnClickListener(View.OnClickListener {
            tiEditText_age.text = null
            tiEditText_height_feet.text = null
            tiEditText_height_inches.text = null
            tiEditText_weight.text = null
        })

    }


    fun intentResult(){
        val heightft = tiEditText_height_feet.text.toString()
        val heightin = tiEditText_height_inches.text.toString()
        val weightlb = tiEditText_weight.text.toString()
        val age = tiEditText_age.text.toString()
        Intent(this, resultsActivity::class.java).also {
            it.putExtra("Extra_heightft", heightft)
            it.putExtra("Extra_heightin", heightin)
            it.putExtra("Extra_weight", weightlb)
            it.putExtra("Extra_age", age)
            it.putExtra("gender", defaultGender)
            startActivity(it)
        }
    }


    private fun changebackgroundColor2() {
        gridlayout_male.setBackgroundColor(Color.parseColor("#FFFFFF"))
        gridlayout_female.setBackgroundColor(Color.parseColor("#96222f3e"))
    }

    private fun changebackgroundColor1() {
        gridlayout_female.setBackgroundColor(Color.parseColor("#FFFFFF"))
        gridlayout_male.setBackgroundColor(Color.parseColor("#96222f3e"))
    }




}


