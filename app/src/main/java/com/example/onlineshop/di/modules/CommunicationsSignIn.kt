package com.example.onlineshop.di.modules

import com.example.onlineshop.signin.SignInCommunications
import com.example.onlineshop.signin.SignInStateCommunication
import com.example.onlineshop.signin.SingInSuccessCommunication
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * @author Vitaly.N on 14.03.2023.
 */
@Module
class CommunicationsSignIn {
    @Provides
    @Named("CommunicationEmail")
    fun provideCommunicationEmail(): SignInCommunications {
        return SignInCommunications.Base(
            SingInSuccessCommunication.Base(),
            SignInStateCommunication.Base()
        )
    }
    @Provides
    @Named("CommunicationFirstName")
    fun provideCommunicationFirstName(): SignInCommunications {
        return SignInCommunications.Base(
            SingInSuccessCommunication.Base(),
            SignInStateCommunication.Base()
        )
    }
    @Provides
    @Named("CommunicationLastName")
    fun provideCommunicationLastName(): SignInCommunications {
        return SignInCommunications.Base(
            SingInSuccessCommunication.Base(),
            SignInStateCommunication.Base()
        )
    }
    @Provides
    fun provideCommunication(): SignInCommunications {
        return SignInCommunications.Base(
            SingInSuccessCommunication.Base(),
            SignInStateCommunication.Base()
        )
    }

}