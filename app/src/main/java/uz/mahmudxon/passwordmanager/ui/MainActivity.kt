package uz.mahmudxon.passwordmanager.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import dagger.android.support.DaggerAppCompatActivity
import uz.mahmudxon.passwordmanager.R
import uz.mahmudxon.passwordmanager.util.Prefs
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var prefs: Prefs

    lateinit var navController: NavController
    lateinit var navGraph: NavGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        navGraph.startDestination = if (prefs.get(Prefs.username, "")
                .isNullOrEmpty()
        ) R.id.signUpFragment else R.id.lockAppFragment
        navController.graph = navGraph
    }

}
