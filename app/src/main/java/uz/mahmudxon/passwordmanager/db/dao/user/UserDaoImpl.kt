package uz.mahmudxon.passwordmanager.db.dao.user

import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import uz.mahmudxon.passwordmanager.db.AppDatabase
import uz.mahmudxon.passwordmanager.db.BaseDaoImpl
import uz.mahmudxon.passwordmanager.model.User
import javax.inject.Inject

class UserDaoImpl @Inject constructor(appDatabase: AppDatabase) : BaseDaoImpl() {
    var userDao: UserDao = appDatabase.userDao()

    fun addUser(user: User) {
        Completable.fromAction {
                userDao.insertUser(user)
            }.subscribeOn(Schedulers.computation())
            .subscribe(object : CompletableObserver {
                override fun onComplete() {
                    databaseCallback?.onCompletableComplete()
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    databaseCallback?.onDatabaseError(e)
                }
            })
    }

    fun deleteUser(user: User) {
        Completable.fromAction {
                userDao.deleteUser(user)
            }.subscribeOn(Schedulers.computation())
            .subscribe(object : CompletableObserver {
                override fun onComplete() {
                    databaseCallback?.onCompletableComplete()
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    databaseCallback?.onDatabaseError(e)
                }
            })
    }

    fun updateUser(user: User) {
        Completable.fromAction {
                userDao.updateUser(user)
            }.subscribeOn(Schedulers.computation())
            .subscribe(object : CompletableObserver {
                override fun onComplete() {
                    databaseCallback?.onCompletableComplete()
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    databaseCallback?.onDatabaseError(e)
                }
            })
    }

    fun getAllUsers() {
        userDao.getAllUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                databaseCallback?.onQueryWithAnswer(it)
            }, {
                databaseCallback?.onDatabaseError(it)
            })
    }

}