package uz.mahmudxon.passwordmanager.ui.lock

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_lock_app.*
import uz.mahmudxon.passwordmanager.R
import uz.mahmudxon.passwordmanager.ui.base.BaseFragment
import uz.mahmudxon.passwordmanager.util.KeyBoardUtil
import uz.mahmudxon.passwordmanager.util.Prefs
import javax.inject.Inject


class LockAppFragment : BaseFragment(R.layout.fragment_lock_app), View.OnClickListener {

    @Inject
    lateinit var prefs: Prefs

    @Inject
    lateinit var keyBoardUtil: KeyBoardUtil

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<FloatingActionButton>(R.id.unlock).setOnClickListener(this)
        keyBoardUtil.shoKeyBoard(password)
    }

    override fun onClick(v: View?) {
        val password = password?.text.toString()
        if (password.trim().isNotEmpty() && password == prefs.get(Prefs.password, "")) {
            keyBoardUtil.hideKeyBoard()
            navController.navigate(R.id.action_lockAppFragment_to_mainFragment)
            return
        }
        Toast.makeText(context, "Wrong password!!!!", Toast.LENGTH_SHORT).show()
    }
}
