package com.nitratz.apexcompanion.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bartoszlipinski.flippablestackview.FlippableStackView
import com.nitratz.apexcompanion.R
import com.nitratz.apexcompanion.stackadapter.LegendsAdapter

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val stack: FlippableStackView = findViewById(R.id.stack)
        stack.initStack(8)
        stack.adapter = LegendsAdapter(this)
    }
}