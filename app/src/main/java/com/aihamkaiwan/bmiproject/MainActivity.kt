package com.example.bmiproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardView_bmi.setOnClickListener(View.OnClickListener {
            openBMIActivity()
        })

        carView_bmr.setOnClickListener(View.OnClickListener {
            startBMRAct()
        })

//        val contactOpt = findViewById<ch>()





    }

    private fun startBMRAct() {
        val moveToBMRActivity = Intent(this, BMRActivity::class.java)
        startActivity(moveToBMRActivity)
    }

    private fun openBMIActivity() {
        val moveToNewActivity = Intent(this, BMIActivity::class.java)
        startActivity(moveToNewActivity)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.app_menu,menu)
        return true


    }

    private fun intentRateApp(){


        val uriBuilder = Uri.parse("https://play.google.com/store/apps/details")
            .buildUpon()
            .appendQueryParameter("id", "com.example.android")
            .appendQueryParameter("launch", "true")

// Optional parameters, such as referrer, are passed onto the launched
// instant app. You can retrieve these parameters using Activity.intent.data.
        uriBuilder.appendQueryParameter("referrer", "exampleCampaignId")
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = uriBuilder.build()
            setPackage("com.android.vending")
        }
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.contactUs -> emailIntent()
            R.id.rateApp -> intentRateApp()
        }
        return true
    }

    private fun emailIntent() {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:aihamcode@gmail.com")
        }
        startActivity(Intent.createChooser(emailIntent, "Send feedback"))
    }

}