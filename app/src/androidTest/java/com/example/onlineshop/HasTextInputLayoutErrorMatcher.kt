package com.example.onlineshop

import android.view.View
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

/**
 * @author Vitaly.N on 14.03.2023.
 */
class HasTextInputLayoutErrorMatcher(private val expectedErrorText: String) :
    TypeSafeMatcher<View>() {

    override fun describeTo(description: Description?) {

    }

    override fun matchesSafely(item: View?): Boolean {
        if (item !is TextInputLayout) {
            return false
        }

        val error = item.error ?: return false

        val errorText = error.toString()

        return expectedErrorText == errorText
    }
}

class TextInputLayoutHasNoError : TypeSafeMatcher<View>() {
    override fun describeTo(description: Description?) {

    }

    override fun matchesSafely(item: View?): Boolean {
        if (item !is TextInputLayout) {
            return false
        }

        val errorEnabled = item.isErrorEnabled
        return !errorEnabled
    }
}