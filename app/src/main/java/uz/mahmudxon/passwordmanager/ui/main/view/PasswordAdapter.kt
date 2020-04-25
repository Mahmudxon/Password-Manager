package uz.mahmudxon.passwordmanager.ui.main.view

import android.view.View
import kotlinx.android.synthetic.main.item_password.view.*
import uz.mahmudxon.passwordmanager.R
import uz.mahmudxon.passwordmanager.model.Password
import uz.mahmudxon.passwordmanager.ui.base.component.recyclerview.SingleTypeAdapter

class PasswordAdapter : SingleTypeAdapter<Password>(R.layout.item_password, ArrayList()) {
    override fun bindData(itemView: View, position: Int) {
        itemView.apply {
            title.text = data[position].title
        }
    }
}