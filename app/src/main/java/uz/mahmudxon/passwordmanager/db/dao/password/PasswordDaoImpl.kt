package uz.mahmudxon.passwordmanager.db.dao.password

import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import uz.mahmudxon.passwordmanager.db.AppDatabase
import uz.mahmudxon.passwordmanager.db.BaseDaoImpl
import uz.mahmudxon.passwordmanager.model.Password
import javax.inject.Inject

class PasswordDaoImpl @Inject constructor(appDatabase: AppDatabase) : BaseDaoImpl() {
    val passwordDao = appDatabase.passwordDao()

    fun addPassWord(data: Password) {
        Completable.fromAction {
                passwordDao.insertPassword(password = data)
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
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

    fun deletePassword(data: Password) {
        Completable.fromAction {
                passwordDao.deletePassword(password = data)
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
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

    fun updatePassword(data: Password) {
        Completable.fromAction {
                passwordDao.updatePassword(password = data)
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
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

    fun getAllPasswords() {
        passwordDao.getAllPasswords()
            .toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                databaseCallback?.onQueryWithAnswer(it)
            }, {
                databaseCallback?.onDatabaseError(it)
            })
    }
}