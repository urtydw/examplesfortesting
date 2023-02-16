package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
           val greetingTextView = findViewById<TextView>(R.id.tvHello)
           val inputField = findViewById<EditText>(R.id.etName)
           val submitButton = findViewById<Button>(R.id.btnSubmit)
           val offersButton = findViewById<Button>(R.id.btnOffers)
           var enteredName = ""
           submitButton.setOnClickListener {
               enteredName = inputField.text.toString()
               if (enteredName == ""){
                     offersButton.visibility = INVISIBLE
                     greetingTextView.text = ""
                     Toast.makeText(
                         this@MainActivity,
                         "Please, enter your name!",
                         Toast.LENGTH_SHORT
                     ).show()
               }else {
                   val message = "Welcome $enteredName"
                   greetingTextView.text = message
                   inputField.text.clear()
                   offersButton.visibility = VISIBLE
               }
           }

          offersButton.setOnClickListener {
           val intent = Intent(this,SecondActivity::class.java)
           intent.putExtra("USER",enteredName)
           startActivity(intent)
          }


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(this,button)
            popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.action_crick ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_ftbal ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.action_hockey ->
                        Toast.makeText(this@MainActivity, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                }
                true
            })
            popupMenu.show()
        }


    }
}