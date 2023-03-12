package com.example.onlineshop.di

import android.content.Context
import com.example.onlineshop.R
import com.example.onlineshop.core.presenter.UiValidator
import com.example.onlineshop.core.UiValidatorChain
import com.example.onlineshop.signin.ui.validator.EmailValidator
import com.example.onlineshop.signin.ui.validator.EmptinessValidator
import com.example.onlineshop.signin.ui.validator.MinLengthValidator
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * @author Vitaly.N on 06.03.2023.
 */
@Module
class ValidatorModule {

    @Provides
    fun provideValidator(context: Context): UiValidator {
        return EmptinessValidator(context.getString(R.string.invalid_email_error_message))
    }

    @Provides
    @Named("Email")
    fun provideValidatorEmail(context: Context): UiValidator {
        val minLength = 6
        return UiValidatorChain(
            EmailValidator(context.getString(R.string.invalid_email_error_message)),
            MinLengthValidator(
                context.getString(R.string.empty_string_error_message), minLength))
    }

    @Provides
    @Named("Login")
    fun provideValidatorlogin(context: Context): UiValidator {
        val minLength = 6
        val empty = EmptinessValidator(context.getString(R.string.empty_string_error_message))
        return UiValidatorChain(
            empty,
            MinLengthValidator(
                context.getString(R.string.invalid_min_length_error_message), minLength))
    }

}