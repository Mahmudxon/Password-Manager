package uz.mahmudxon.passwordmanager.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import uz.mahmudxon.passwordmanager.application.BaseApplication
import uz.mahmudxon.passwordmanager.di.module.app.AppModule
import uz.mahmudxon.passwordmanager.di.module.ui.ActivityBuilderModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, AppModule::class])
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

}