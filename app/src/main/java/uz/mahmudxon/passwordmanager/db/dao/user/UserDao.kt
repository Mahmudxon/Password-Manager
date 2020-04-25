package uz.mahmudxon.passwordmanager.db.dao.user

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import uz.mahmudxon.passwordmanager.model.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User): Completable

    @Delete
    fun deleteUser(user: User): Completable

    @Update
    fun updateUser(user: User): Completable

    @Query("select * from User")
    fun getAllUsers(): Single<List<User>>
}