package com.erman.pegsolitarie

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GameSelectionDialogListener {

    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        gameGridHolder.addView(constructEnglishBoard(this))

        gameMenuButton.setOnClickListener {
            val newFragment = GameSelectionFragment()
            newFragment.show(fragmentManager, "")
        }

    }

    override fun gameSelectionDialogListener(gameSelection: String) {
        if(gameSelection == KEY_ENGLISH_BOARD) {
            gameGridHolder.removeAllViews()
            gameGridHolder.addView(constructEnglishBoard(this))
        }
    }
}