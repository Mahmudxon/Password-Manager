package uz.mahmudxon.passwordmanager.ui.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_auth.*
import uz.mahmudxon.passwordmanager.R
import uz.mahmudxon.passwordmanager.ui.base.BaseFragment
import uz.mahmudxon.passwordmanager.util.KeyBoardUtil
import uz.mahmudxon.passwordmanager.util.Prefs
import javax.inject.Inject

class AuthFragment : BaseFragment(R.layout.fragment_auth), View.OnClickListener {

    @Inject
    lateinit var prefs: Prefs

    @Inject
    lateinit var keyBoardUtil: KeyBoardUtil

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<FloatingActionButton>(R.id.start).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val username = username?.text.toString()
        val email = email?.text.toString()
        val password = password?.text.toString()
        val confirm = confirmation?.text.toString()
        if (username.isNullOrBlank() || email.isNullOrBlank() || password.isNullOrBlank() || confirm.isNullOrBlank()) {
            Toast.makeText(context, "All fields are required!!!", Toast.LENGTH_LONG).show()
            return
        }

        if (password != confirm) {
            Toast.makeText(context, "Passwords don't match!", Toast.LENGTH_SHORT).show()
            return
        }

        prefs.save(Prefs.username, username)
        prefs.save(Prefs.email, email)
        prefs.save(Prefs.password, password)
        keyBoardUtil.hideKeyBoard()
        navController.navigate(R.id.action_signUpFragment_to_mainFragment)
    }
}