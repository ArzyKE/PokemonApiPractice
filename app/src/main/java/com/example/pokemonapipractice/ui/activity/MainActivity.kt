package com.example.pokemonapipractice.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokemonapipractice.R
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}