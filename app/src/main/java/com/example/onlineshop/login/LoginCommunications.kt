package com.example.onlineshop.login

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.core.presenter.Communication
import com.example.onlineshop.signin.ui.UiState

/**
 * @author Vitaly.N on 05.03.2023.
 */
interface LoginCommunications : ObserveLogin {

    fun showState(uiState: UiState)

    fun loginSuccess(success: Boolean)

    class Base(
        private val loginSuccess: LoginSuccessCommunication,
        private val state: LoginStateCommunication,
    ) : LoginCommunications {

        override fun showState(uiState: UiState) = state.map(uiState)

        override fun loginSuccess(success: Boolean) {
            loginSuccess.map(success)
        }

        override fun observeLoginSuccess(owner: LifecycleOwner, observer: Observer<Boolean>) {
            loginSuccess.observe(owner,observer)
        }

        override fun observeStateFirstName(owner: LifecycleOwner, observer: Observer<UiState>) {
            state.observe(owner, observer)
        }

        override fun observeStatePassword(owner: LifecycleOwner, observer: Observer<UiState>) {
            state.observe(owner, observer)
        }
    }
}

interface ObserveLogin {
    fun observeLoginSuccess(owner: LifecycleOwner, observer: Observer<Boolean>)
    fun observeStateFirstName(owner: LifecycleOwner, observer: Observer<UiState>)
    fun observeStatePassword(owner: LifecycleOwner, observer: Observer<UiState>)
}

interface LoginStateCommunication : Communication.Mutable<UiState> {
    class Base : Communication.Ui<UiState>(), LoginStateCommunication
}
interface LoginSuccessCommunication: Communication.Mutable<Boolean> {
    class Base : Communication.Ui<Boolean>(), LoginSuccessCommunication
}
