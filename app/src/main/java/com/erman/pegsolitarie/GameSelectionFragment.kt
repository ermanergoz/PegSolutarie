package com.erman.pegsolitarie

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.DialogFragment

class GameSelectionFragment : DialogFragment() {

    private lateinit var listener: GameSelectionDialogListener
    private lateinit var dialogView: View

    private lateinit var frenchButton: Button
    private lateinit var germanButton: Button
    private lateinit var asymmetricalButton: Button
    private lateinit var englishButton: Button
    private lateinit var diamondButton: Button
    private lateinit var triangularButton: Button

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    return activity?.let {

        val builder = AlertDialog.Builder(it)
        val inflater = requireActivity().layoutInflater
        dialogView = inflater.inflate(R.layout.dialog_game_selection, null)

        this.frenchButton = dialogView.findViewById(R.id.frenchButton)
        this.germanButton = dialogView.findViewById(R.id.germanButton)
        this.asymmetricalButton = dialogView.findViewById(R.id.asymmetricalButton)
        this.englishButton = dialogView.findViewById(R.id.englishButton)
        this.diamondButton = dialogView.findViewById(R.id.diamondButton)
        this.triangularButton = dialogView.findViewById(R.id.triangularButton)

        englishButton.setOnClickListener {
            listener.gameSelectionDialogListener(KEY_ENGLISH_BOARD)
            dialog?.dismiss()
        }

        builder.setView(dialogView)
        builder.create()
    } ?: throw IllegalStateException("Activity cannot be null")
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