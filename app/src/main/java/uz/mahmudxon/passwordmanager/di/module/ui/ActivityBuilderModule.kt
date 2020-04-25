package uz.mahmudxon.passwordmanager.di.module.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.mahmudxon.passwordmanager.ui.MainActivity

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainActivityFragmentProvider::class])
    abstract fun contributeMainActivity(): MainActivity

}