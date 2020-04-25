package uz.mahmudxon.passwordmanager.db.dao.password

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable
import uz.mahmudxon.passwordmanager.model.Password

@Dao
interface PasswordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPassword(password: Password): Completable

    @Update
    fun updatePassword(password: Password): Completable

    @Delete
    fun deletePassword(password: Password): Completable

    @Query("select * from 'Password' order by title")
    fun getAllPasswords(): Flowable<List<Password>>
}