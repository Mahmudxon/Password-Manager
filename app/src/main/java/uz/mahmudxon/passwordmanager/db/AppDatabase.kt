package uz.mahmudxon.passwordmanager.db

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.mahmudxon.passwordmanager.db.dao.password.PasswordDao
import uz.mahmudxon.passwordmanager.db.dao.user.UserDao
import uz.mahmudxon.passwordmanager.model.Password
import uz.mahmudxon.passwordmanager.model.User

@Database(entities = [Password::class, User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun passwordDao(): PasswordDao
}