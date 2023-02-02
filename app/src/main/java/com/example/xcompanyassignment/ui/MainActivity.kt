package com.example.xcompanyassignment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.xcompanyassignment.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}