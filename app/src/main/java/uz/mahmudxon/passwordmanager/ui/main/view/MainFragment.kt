package uz.mahmudxon.passwordmanager.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import uz.mahmudxon.passwordmanager.R
import uz.mahmudxon.passwordmanager.model.Password
import uz.mahmudxon.passwordmanager.ui.base.BaseFragment
import uz.mahmudxon.passwordmanager.ui.main.Main
import javax.inject.Inject

class MainFragment : BaseFragment(R.layout.fragment_main), Main.View, View.OnClickListener {

    @Inject
    lateinit var presenter: Main.Presenter

    @Inject
    lateinit var listAdapter: PasswordAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list?.layoutManager = linearLayoutManager
        list?.adapter = listAdapter
        presenter.loadData()
        setOnClicks()
    }

    private fun setOnClicks() {
        add.setOnClickListener(this)
    }

    override fun swapData(arrayList: ArrayList<Password>) {
        listAdapter.swapdata(arrayList)
    }


    override fun showProgress() {
        progress?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress?.visibility = View.GONE
    }

    override fun showError(message: String?) {
        Toast.makeText(context, "$message", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.add -> {
                navController.navigate(R.id.action_mainFragment_to_addFragment)
            }
        }
    }
}