package uz.mahmudxon.passwordmanager.application

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import uz.mahmudxon.passwordmanager.di.component.DaggerAppComponent

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}