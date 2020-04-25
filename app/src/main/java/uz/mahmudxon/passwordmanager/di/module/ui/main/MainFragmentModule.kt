package uz.mahmudxon.passwordmanager.di.module.ui.main

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import uz.mahmudxon.passwordmanager.ui.main.Main
import uz.mahmudxon.passwordmanager.ui.main.presenter.MainPresenter
import uz.mahmudxon.passwordmanager.ui.main.view.MainFragment
import uz.mahmudxon.passwordmanager.ui.main.view.PasswordAdapter

@Module
class MainFragmentModule {
    @Provides
    fun provideView(fragment: MainFragment): Main.View = fragment

    @Provides
    fun provideAdapter(): PasswordAdapter = PasswordAdapter()

    @Provides
    fun provideLinerLayoutManager(ctx: Context) = LinearLayoutManager(ctx)

    @Provides
    fun providePresenter(presenter: MainPresenter): Main.Presenter = presenter
}