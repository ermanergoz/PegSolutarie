package com.erman.pegsolitarie.activities

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.erman.pegsolitarie.R
import com.erman.pegsolitarie.fragments.EnglishBoardFragment

class MainActivity : AppCompatActivity() {

    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        fragmentManager.beginTransaction().add(R.id.fragmentHolder, EnglishBoardFragment()).addToBackStack("").commit()
    }
}