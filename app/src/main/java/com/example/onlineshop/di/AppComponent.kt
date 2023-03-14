package com.example.onlineshop.di

import android.app.Application
import android.content.Context
import com.example.onlineshop.MainActivity
import com.example.onlineshop.detail.ui.DetailProductFragment
import com.example.onlineshop.home.HomeFragment
import com.example.onlineshop.login.LoginFragment
import com.example.onlineshop.signin.ui.SignInFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

/**
 * @author Vitaly.N on 05.03.2023.
 */
@[AppScope Component(modules = [AppModule::class, ContextModule::class, LoginDataBaseModule::class, LoginCacheDataSourceModule::class,
        LoginRepositoryModule::class, LoginIteractorModule::class, ValidatorModule::class,
        LatestCloudDataSourceModule::class, LatestRepositoryModule::class, FlashSaleCloudDataSourceModule::class,
        FlashSaleRepositoryModule::class, ProductIteractorModule::class, ProductDetailCloudDataSourceModule::class,
        ProductDetailRepositoryModule::class, ProductDetailIteractorModule::class])]

interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: SignInFragment)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: DetailProductFragment)
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }




//    @Component.Factory
//    interface AppComponentFactory {
//        fun create(@BindsInstance context: Context): AppComponent
//    }

}
@Scope
annotation class AppScope