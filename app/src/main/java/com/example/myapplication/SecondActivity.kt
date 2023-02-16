package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val userName = intent.getStringExtra("USER")
        val textView = findViewById<TextView>(R.id.tvOffer)
        val message = "$userName ,you will get  free access to all the content for one month "
        textView.text = message


        val languages = resources.getStringArray(R.array.programming_languages)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, languages)
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        autocompleteTV.setAdapter(arrayAdapter)

    }
}