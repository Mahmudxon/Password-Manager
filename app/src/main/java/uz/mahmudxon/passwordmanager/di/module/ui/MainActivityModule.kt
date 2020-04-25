package uz.mahmudxon.passwordmanager.di.module.ui

import dagger.Module
import dagger.Provides
import uz.mahmudxon.passwordmanager.ui.MainActivity
import uz.mahmudxon.passwordmanager.util.KeyBoardUtil

@Module
class MainActivityModule {
    @Provides
    fun provideKeyboardUtils(mainActivity: MainActivity) = KeyBoardUtil(mainActivity)
}