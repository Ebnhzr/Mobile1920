package com.github.ebnhzr.meeting07_dorahideandseek2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.github.ebnhzr.meeting07_dorahideandseek2.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout
        val navController = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
    override fun onStart(){
        super.onStart()
        Timber.i("-onStart")
    }
    override fun onResume() {
        super.onResume()
        Timber.i("-onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("-onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("-onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("-onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("-onRestart")
    }
}
