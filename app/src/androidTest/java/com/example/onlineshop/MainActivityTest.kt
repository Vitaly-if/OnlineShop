package com.example.onlineshop

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test() {
        onView(withId(R.id.signInButton)).perform(click())
        onView(withId(R.id.signInButton)).check(matches(isDisplayed()))
        onView(withId(R.id.firstNameTextInputLayout)).check(matches(HasTextInputLayoutErrorMatcher("Поле не должно быть пустым")))
        onView(withId(R.id.lastNameTextInputLayout)).check(matches(HasTextInputLayoutErrorMatcher("Поле не должно быть пустым")))
        onView(withId(R.id.emailSignInTextInputLayout)).check(
            matches(
                HasTextInputLayoutErrorMatcher(
                    "Введен некорректный email"
                )
            )
        )
        onView(withId(R.id.emailSignInEditText)).perform(typeText("j"), closeSoftKeyboard())
        onView(withId(R.id.emailSignInTextInputLayout)).check(
            matches(TextInputLayoutHasNoError())
        )
        onView(withId(R.id.signInButton)).perform(click())
        onView(withId(R.id.emailSignInTextInputLayout)).check(
            matches(
                HasTextInputLayoutErrorMatcher(
                    "Введен некорректный email"
                )
            )
        )

        onView(withId(R.id.firstNameSignInEditText)).perform(replaceText("12345"))
        onView(withId(R.id.lastNameEditText)).perform(replaceText("12345"))
        onView(withId(R.id.emailSignInEditText)).perform(
            replaceText("vitlynak@gmail.com"),
            closeSoftKeyboard()
        )

        onView(withId(R.id.signInButton)).perform(click())
        onView(withId(R.id.emailSignInTextInputLayout)).check(
            matches(TextInputLayoutHasNoError())
        )

        onView(withId(R.id.firstNameTextInputLayout)).check(matches(HasTextInputLayoutErrorMatcher("Несоответствует минимальному количеству символов")))
        onView(withId(R.id.lastNameTextInputLayout)).check(matches(HasTextInputLayoutErrorMatcher("Несоответствует минимальному количеству символов")))

        onView(withId(R.id.firstNameSignInEditText)).perform(replaceText("1234567"))
        onView(withId(R.id.lastNameEditText)).perform(replaceText("123456"), closeSoftKeyboard())
        onView(withId(R.id.signInButton)).perform(click())

        onView(withId(R.id.lastNameTextInputLayout)).check(
            matches(TextInputLayoutHasNoError())
        )
    }
}