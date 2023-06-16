package com.capstone.botaniscan

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.auth0.jwt.JWT
import com.auth0.jwt.interfaces.DecodedJWT
import com.capstone.botaniscan.data.session.DataPreferences
import com.capstone.botaniscan.databinding.ActivityMainBinding
import com.capstone.botaniscan.model.SessionViewModel
import com.capstone.botaniscan.model.ViewModelFactory
import com.capstone.botaniscan.ui.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "session")

    @SuppressLint("AppCompatMethod")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_store, R.id.navigation_riwayat, R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



        val pref = DataPreferences.getInstance(dataStore)
        val sessionViewModel = ViewModelProvider(this, ViewModelFactory(pref))[SessionViewModel::class.java]

        sessionViewModel.getSession().observe(this) {

            if (!it.isLogin) {
                toLogin()
                finish()
            } else{
                val cekToken: DecodedJWT = JWT.decode(it.token)
                if (cekToken.expiresAt.before(Date())) {
                    sessionViewModel.removeSession()
                    toLogin()
                }

            }

        }

    }

private fun toLogin(){
    startActivity(Intent(this@MainActivity, LoginActivity::class.java))
}

}
