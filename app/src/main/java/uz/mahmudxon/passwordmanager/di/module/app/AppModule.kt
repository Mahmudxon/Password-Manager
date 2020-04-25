package uz.mahmudxon.passwordmanager.di.module.app

import android.app.Application
import dagger.Module
import dagger.Provides
import uz.mahmudxon.passwordmanager.di.module.db.RoomModule
import uz.mahmudxon.passwordmanager.util.Prefs

@Module(includes = [RoomModule::class])
object AppModule
{

    @Provides
    fun provideContext(application: Application) = application.applicationContext

    @Provides
    fun providePrefs(application: Application) = Prefs(application)
}