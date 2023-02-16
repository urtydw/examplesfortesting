package com.example.myapplication

import android.view.View
import android.widget.TextView

import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

class HintTextMatcher :
    BoundedMatcher<View?, TextView?>(TextView::class.java) {

    override fun describeTo(description: Description?) {
        description?.appendText("text");
    }
    override fun matchesSafely(item: TextView?): Boolean {
        var result = false
        if (item != null) {
            println("TEXXXXTTTT!!!")
            result = item.text == "Hello From Android!"
        }
        return result
    }
}