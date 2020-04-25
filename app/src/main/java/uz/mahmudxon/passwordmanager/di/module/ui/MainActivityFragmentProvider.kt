package uz.mahmudxon.passwordmanager.di.module.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.mahmudxon.passwordmanager.di.module.ui.add.AddFragmentModule
import uz.mahmudxon.passwordmanager.di.module.ui.auth.AuthFragmantModule
import uz.mahmudxon.passwordmanager.di.module.ui.lock.LockAppFragmentModule
import uz.mahmudxon.passwordmanager.di.module.ui.main.MainFragmentModule
import uz.mahmudxon.passwordmanager.ui.add.view.AddFragment
import uz.mahmudxon.passwordmanager.ui.auth.AuthFragment
import uz.mahmudxon.passwordmanager.ui.lock.LockAppFragment
import uz.mahmudxon.passwordmanager.ui.main.view.MainFragment

@Module
abstract class MainActivityFragmentProvider {

    @ContributesAndroidInjector(modules = [AuthFragmantModule::class])
    abstract fun contributeAuthFragment(): AuthFragment

    @ContributesAndroidInjector(modules = [LockAppFragmentModule::class])
    abstract fun contributeLockAppFragment(): LockAppFragment

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector(modules = [AddFragmentModule::class])
    abstract fun contributeAddFragment(): AddFragment
}