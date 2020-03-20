package com.erman.pegsolitarie

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_game_selection.*

class GameSelectionFragment : Fragment() {

    private lateinit var listener: GameSelectionDialogListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        englishButton.setOnClickListener {
            listener.gameSelectionDialogListener(KEY_ENGLISH_BOARD)
        }
    }
    
    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = context as GameSelectionDialogListener
        } catch (err: ClassCastException) {
            Log.e("error", "must implement GameSelectionDialogListener")
        }
    }
}

interface GameSelectionDialogListener {
    fun gameSelectionDialogListener(selectedGame: String)
}