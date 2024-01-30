package com.mendhie.movemate.presentation.activities

import android.os.Bundle
import android.view.View
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.mendhie.movemate.R
import com.mendhie.movemate.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navFragment = supportFragmentManager.findFragmentById(R.id.navHostMain) as NavHostFragment
        val navController = navFragment.navController
        NavigationUI.setupWithNavController(binding.navMain, navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->

            if (destination.id == R.id.navHome) {
                binding.navMain.visibility = View.VISIBLE
                val animate: TranslateAnimation = TranslateAnimation(
                    0f,
                    0f,
                    binding.navMain.height.toFloat(),
                    0f
                )
                // duration of animation
                animate.duration = 500
                animate.fillAfter = true
                binding.navMain.startAnimation(animate)
            }
            else {
                binding.navMain.visibility = View.GONE
                val animate: TranslateAnimation = TranslateAnimation(
                    0f,
                    0f,
                    0f,
                    binding.navMain.height.toFloat()
                )
                // duration of animation
                animate.duration = 500
                animate.fillAfter = true;
                binding.navMain.startAnimation(animate)
            }

        }
    }
}