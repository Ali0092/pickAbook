package com.example.pickabook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.pickabook.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().apply {
            this.setKeepOnScreenCondition {
                delayer()
            }
        }
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFrag) as NavHostFragment
        val navController = navHostFragment.navController
        binding.nvView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{ c,destination, a ->
            if(destination.id==R.id.categoryScreen){
                binding.drawerBtn.visibility= View.VISIBLE
                binding.mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }else{
                binding.drawerBtn.visibility= View.GONE
                binding.mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }

      /*  binding.drawerBtn.setOnClickListener {
            binding.mDrawerLayout.open()
        }

       */
    }

    private fun delayer(): Boolean {
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
        }
        return false
    }
}