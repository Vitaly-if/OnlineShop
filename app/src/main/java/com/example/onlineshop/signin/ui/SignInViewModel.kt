package com.example.onlineshop.signin

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.presenter.UiValidator
import com.example.onlineshop.signin.domain.LoginIteractor
import com.example.onlineshop.signin.domain.LoginResult
import com.example.onlineshop.signin.ui.UiState
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

/**
 * @author Vitaly.N on 04.03.2023.
 */
class SignInViewModel @Inject constructor(
    private val iterator: LoginIteractor,
    @Named("Email") private val validatorEmail: UiValidator,
    @Named("Login") private val validatorLogin: UiValidator,
    @Named("CommunicationFirstName") private val communicationsFirstName: SignInCommunications,
    @Named("CommunicationLastName") private val communicationsLastName: SignInCommunications,
    @Named("CommunicationEmail") private val communicationsEmail: SignInCommunications,
) : ViewModel(), ObserveSingIn, ClearError, SignIn {

    override fun observeLoginSuccess(owner: LifecycleOwner, observer: Observer<Boolean>) {
        communicationsFirstName.observeLoginSuccess(owner, observer)
    }

    override fun observeStateFirstName(owner: LifecycleOwner, observer: Observer<UiState>) {
        communicationsFirstName.observeStateFirstName(owner, observer)
    }

    override fun clearError() {
        communicationsFirstName.showState(UiState.ClearError())
        communicationsLastName.showState(UiState.ClearError())
        communicationsEmail.showState(UiState.ClearError())
    }

    override fun signIn(firstName: String, lastName: String, email: String): Boolean {
        var inputPermission = true

        if (!validatorLogin.isValid(firstName)) {
            communicationsFirstName.showState(UiState.ShowError(validatorLogin.errorMessage()))
            inputPermission = false
        }
        if (!validatorLogin.isValid(lastName)) {
            communicationsLastName.showState(UiState.ShowError(validatorLogin.errorMessage()))
            inputPermission = false
        }
        if (!validatorEmail.isValid(email)) {
            communicationsEmail.showState(UiState.ShowError(validatorEmail.errorMessage()))
            inputPermission = false
        }
        if (inputPermission) {
            viewModelScope.launch {
                if (iterator.checkLogin(firstName) is LoginResult.Failure) {
                    communicationsFirstName.showState(UiState.ShowError("Логин уже существует"))
                    communicationsFirstName.loginSuccess(false)
                } else
                    communicationsFirstName.loginSuccess(true)
                iterator.insertLogin(firstName, "123456")
            }
        }
        return inputPermission
    }

    override fun observeStateLastName(owner: LifecycleOwner, observer: Observer<UiState>) {
        communicationsLastName.observeStateLastName(owner, observer)
    }

    override fun observeStateEmail(owner: LifecycleOwner, observer: Observer<UiState>) {
        communicationsEmail.observeStateEmail(owner, observer)
    }
}

interface SignIn {
    fun signIn(firstName: String, lastName: String, email: String): Boolean
}

interface ClearError {
    fun clearError()
}