package com.example.onlineshop.signin

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.core.presenter.Communication
import com.example.onlineshop.login.LoginSuccessCommunication
import com.example.onlineshop.signin.ui.UiState

/**
 * @author Vitaly.N on 04.03.2023.
 */
interface SignInCommunications : ObserveSingIn {

    fun showState(uiState: UiState)

    fun loginSuccess(success: Boolean)

    class Base(
        private val loginSuccess: LoginSuccessCommunication,
        private val state: SignInStateCommunication,
    ) : SignInCommunications {

        override fun showState(uiState: UiState) = state.map(uiState)

        override fun loginSuccess(success: Boolean) {
            loginSuccess.map(success)
        }

        override fun observeLoginSuccess(owner: LifecycleOwner, observer: Observer<Boolean>) {
            loginSuccess.observe(owner, observer)
        }

        override fun observeStateFirstName(owner: LifecycleOwner, observer: Observer<UiState>) {
            state.observe(owner, observer)
        }

        override fun observeStateLastName(owner: LifecycleOwner, observer: Observer<UiState>) {
            state.observe(owner, observer)
        }

        override fun observeStateEmail(owner: LifecycleOwner, observer: Observer<UiState>) {
            state.observe(owner, observer)
        }
    }
}

interface ObserveSingIn {
    fun observeLoginSuccess(owner: LifecycleOwner, observer: Observer<Boolean>)
    fun observeStateFirstName(owner: LifecycleOwner, observer: Observer<UiState>)
    fun observeStateLastName(owner: LifecycleOwner, observer: Observer<UiState>)
    fun observeStateEmail(owner: LifecycleOwner, observer: Observer<UiState>)
}

interface SignInStateCommunication : Communication.Mutable<UiState> {
    class Base : Communication.Ui<UiState>(), SignInStateCommunication
}

interface SingInSuccessCommunication : Communication.Mutable<Boolean> {
    class Base : Communication.Ui<Boolean>(), LoginSuccessCommunication
}
