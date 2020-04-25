package uz.mahmudxon.passwordmanager.ui.main

import uz.mahmudxon.passwordmanager.model.Password

interface Main {

    interface View {
        fun swapData(arrayList: ArrayList<Password>)
        fun showProgress()
        fun hideProgress()
        fun showError(message : String?)
    }

    interface Presenter {
        fun loadData()
        fun refreshData()
        fun deleteData(password: Password)
        fun updateData(password: Password)
        fun insertData(password: Password)
    }

}