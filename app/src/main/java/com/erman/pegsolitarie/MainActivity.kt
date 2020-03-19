package com.erman.pegsolitarie

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), GameSelectionFragmentListener {

    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, GameSelectionFragment()).addToBackStack("").commit()
    }

    override fun gameSelectionFragmentListener(selectedGame: String) {
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, GameFragment(selectedGame)).addToBackStack("").commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (fragmentManager.backStackEntryCount == 0)
            finish()
    }
}