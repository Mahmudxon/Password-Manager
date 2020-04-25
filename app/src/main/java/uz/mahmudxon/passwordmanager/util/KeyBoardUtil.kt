package uz.mahmudxon.passwordmanager.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

class KeyBoardUtil(val activity: Activity) {
    fun hideKeyBoard() {
        val view = activity.currentFocus ?: View(activity)
        val imm = this.activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun shoKeyBoard(et: EditText) {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        et.requestFocus()
        et.isCursorVisible = true
    }
}