package com.example.myapplication

import android.view.KeyEvent
import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class HelloWorldEspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun textFieldTest() {
        onView(withText("Hello From Android!")).check(matches(isDisplayed()))
        onView(withId(R.id.etName)).perform(click())
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText("test"),
            pressKey(KeyEvent.KEYCODE_ENTER)
        )
    }
    @Test
    fun textFieldAlternativeMatcherTest() {
        onView(withText("Hello From Android!")).check(matches(isDisplayed()))
        onView(withId(R.id.tvHello)).check(matches(HintTextMatcher()))
    }
    @Test
    fun hintCustomMatcherTest() {
        onView(withText("Hello From Android!")).check(matches(isDisplayed()))
        onView(withId(R.id.etName)).check(matches(CustomHintMatcher()))
    }

    @Test
    fun hintCustomMatcherTest2() {
        onView(withId(R.id.button)).perform(click())
        onView(withText("Hockey")).perform(click())
    }

    @Test
    fun clickPopupMenuByTextTest() {
        onView(withId(R.id.button)).perform(click())
        onView(withText("Hockey")).perform(click())
    }
    @Test
    fun clickPopupMenuByIdTest() {
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.action_hockey)).perform(click())
    }

}