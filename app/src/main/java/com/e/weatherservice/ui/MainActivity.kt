package com.e.weatherservice.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.e.weatherservice.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}