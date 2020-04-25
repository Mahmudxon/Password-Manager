package uz.mahmudxon.passwordmanager.ui.main.presenter

import uz.mahmudxon.passwordmanager.db.DatabaseCallback
import uz.mahmudxon.passwordmanager.db.dao.password.PasswordDaoImpl
import uz.mahmudxon.passwordmanager.model.Password
import uz.mahmudxon.passwordmanager.ui.main.Main
import javax.inject.Inject

class MainPresenter @Inject constructor(val view: Main.View, val passwordDaoImpl: PasswordDaoImpl) :
    Main.Presenter, DatabaseCallback {


    init {
        passwordDaoImpl.databaseCallback = this
    }

    //MainPresenter
    override fun loadData() {
        view.showProgress()
        passwordDaoImpl.getAllPasswords()
    }

    override fun refreshData() {
        loadData()
    }

    override fun deleteData(password: Password) {
        passwordDaoImpl.deletePassword(password)
    }

    override fun updateData(password: Password) {
        passwordDaoImpl.addPassWord(password)
    }

    override fun insertData(password: Password) {
        passwordDaoImpl.addPassWord(password)
    }

    //DatabaseCallBack
    override fun onDatabaseError(error: Throwable) {
        view.showError(error.message)
        view.hideProgress()
    }

    override fun onCompletableComplete() {
        refreshData()
    }

    override fun onQueryWithAnswer(data: Any?) {
        if (data !is List<*> || data.isEmpty() || data[0] !is Password)
        {
            // no data yet
            view.hideProgress()
            return
        }
        val sender = ArrayList<Password>()
        sender.addAll(data as List<Password>)
        view.swapData(sender)
        view.hideProgress()
    }
}