package com.example.onlineshop.di.modules

import com.example.onlineshop.login.LoginCommunications
import com.example.onlineshop.login.LoginStateCommunication
import com.example.onlineshop.login.LoginSuccessCommunication
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * @author Vitaly.N on 14.03.2023.
 */
@Module
class CommunicationsLoginModule {

    @Provides
    @Named("CommunicationFirstName")
    fun provideCommunicationFirstName(): LoginCommunications {
        return LoginCommunications.Base(
            LoginSuccessCommunication.Base(),
            LoginStateCommunication.Base()
        )
    }
    @Provides
    @Named("CommunicationPassword")
    fun provideCommunicationPassword(): LoginCommunications {
        return LoginCommunications.Base(
            LoginSuccessCommunication.Base(),
            LoginStateCommunication.Base()
        )
    }
    @Provides
    fun provideCommunication(): LoginCommunications {
        return LoginCommunications.Base(
            LoginSuccessCommunication.Base(),
            LoginStateCommunication.Base()
        )
    }
}