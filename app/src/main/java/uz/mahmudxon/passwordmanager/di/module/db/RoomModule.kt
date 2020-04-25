package uz.mahmudxon.passwordmanager.di.module.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import uz.mahmudxon.passwordmanager.db.AppDatabase

@Module
class RoomModule {

    @Provides
    fun provideDatabase(ctx: Context) =
        Room.databaseBuilder(ctx, AppDatabase::class.java, ctx.packageName.replace(".", "")).build()

}