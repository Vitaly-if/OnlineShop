package com.example.onlineshop.di

import android.content.Context
import com.example.onlineshop.MainActivity
import com.example.onlineshop.detail.ui.DetailProductFragment
import com.example.onlineshop.home.HomeFragment
import com.example.onlineshop.login.LoginFragment
import com.example.onlineshop.signin.ui.SignInFragment
import dagger.BindsInstance
import dagger.Component

/**
 * @author Vitaly.N on 05.03.2023.
 */
@Component(
    modules = [AppModule::class, LoginDataBaseModule::class, LoginCacheDataSourceModule::class,
        LoginRepositoryModule::class, LoginIteractorModule::class, ValidatorModule::class,
        LatestCloudDataSourceModule::class, LatestRepositoryModule::class, FlashSaleCloudDataSourceModule::class,
        FlashSaleRepositoryModule::class, ProductIteractorModule::class, ProductDetailCloudDataSourceModule::class,
        ProductDetailRepositoryModule::class, ProductDetailIteractorModule::class]
)
interface AppComponent {
    fun context(): Context
    fun inject(activity: MainActivity)
    fun inject(fragment: SignInFragment)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: DetailProductFragment)

    @Component.Factory
    interface AppComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }

}