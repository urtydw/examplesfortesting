package com.example.myapplication

import android.view.View
import android.widget.EditText
import android.widget.TextView

import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

class PopUpMatcher :
    BoundedMatcher<View?, EditText?>(EditText::class.java) {

    override fun describeTo(description: Description?) {
        description?.appendText("textttt");
    }
    override fun matchesSafely(item: EditText?): Boolean {
        var result = false
        if (item != null) {
            println("TEXXXXTTTT!!!")
            result = item.hint.toString() == "Type your name here"
        }
        return result
    }
}