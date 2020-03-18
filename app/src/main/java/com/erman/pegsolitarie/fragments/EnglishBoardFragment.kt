package com.erman.pegsolitarie.fragments

import android.content.res.Resources
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.erman.pegsolitarie.R
import com.erman.pegsolitarie.views.GridView
import kotlinx.android.synthetic.main.fragment_english_board.*

class EnglishBoardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_english_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            160f,
            resources.displayMetrics
        )

        var gameView = GridView(
            context,
            7,
            7,
            Resources.getSystem().displayMetrics.widthPixels,
            Resources.getSystem().displayMetrics.heightPixels-px.toInt(),
            null
        )
        gameView.id = R.id.gameView

        linearLayout.addView(gameView)
    }
}