package com.example.onlineshop.login

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
 * @author Vitaly.N on 05.03.2023.
 */
class LoginViewModel @Inject constructor(
    private val iterator: LoginIteractor,
    @Named("Login") private val validatorLogin: UiValidator,
) : ViewModel(), ObserveLogin, ClearError, Login {

    private val communicationsFirstName = LoginCommunications.Base(
        LoginSuccessCommunication.Base(),
        LoginStateCommunication.Base()
    )
    private val communicationsPassword = LoginCommunications.Base(
        LoginSuccessCommunication.Base(),
        LoginStateCommunication.Base()
    )

    override fun observeLoginSuccess(owner: LifecycleOwner, observer: Observer<Boolean>) {
        communicationsFirstName.observeLoginSuccess(owner, observer)
    }

    override fun observeStateFirstName(owner: LifecycleOwner, observer: Observer<UiState>) {
        communicationsFirstName.observeStateFirstName(owner, observer)
    }

    override fun observeStatePassword(owner: LifecycleOwner, observer: Observer<UiState>) {
        communicationsPassword.observeStatePassword(owner, observer)
    }

    override fun login(firstName: String, password: String) {
        var inputPermission = true
        if (!validatorLogin.isValid(firstName)) {
            communicationsFirstName.showState(UiState.ShowError(validatorLogin.errorMessage()))
            inputPermission = false
        }
        if (!validatorLogin.isValid(password)) {
            communicationsPassword.showState(UiState.ShowError(validatorLogin.errorMessage()))
            inputPermission = false
        }
        if (inputPermission) {
            viewModelScope.launch {
                if (iterator.fetchLogin(firstName, password) is LoginResult.Failure) {
                    communicationsFirstName.showState(UiState.ShowError("Логин не существует или пароль неверный"))
                    communicationsPassword.showState(UiState.ShowError("Логин не существует или пароль неверный"))
                    communicationsFirstName.loginSuccess(false)
                } else
                    communicationsFirstName.loginSuccess(true)
            }
        }

    }

    override fun clearError() {
        communicationsFirstName.showState(UiState.ClearError())
        communicationsPassword.showState(UiState.ClearError())
    }
}

interface Login {
    fun login(firstName: String, password: String)
}

interface ClearError {
    fun clearError()
}