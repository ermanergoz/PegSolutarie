package com.erman.pegsolitarie.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class GridView(
    context: Context?,
    private var numColumns: Int,
    private var numRows: Int,
    private var screenWidth: Int,
    private var screenHeight: Int,
    attrs: AttributeSet?
) :
    View(context, attrs) {

    private var cellWidth = 0
    private var cellHeight = 0
    private val blackPaint: Paint = Paint()
    private var cellChecked: Array<BooleanArray> = Array(numColumns) { BooleanArray(numRows) }
    /*
        override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
            super.onSizeChanged(w, h, oldw, oldh)
            calculateDimensions()
        }
    */
    private fun calculateDimensions() {
        if (numColumns < 1 || numRows < 1) {
            return
        }

        cellWidth = screenWidth / numColumns
        cellHeight = (screenHeight) / numRows

        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        calculateDimensions()

        canvas.drawColor(Color.WHITE)
        if (numColumns == 0 || numRows == 0) {
            return
        }
        val width = screenWidth
        val height = screenHeight
        Log.e("width and height", screenWidth.toString() + " - " + screenHeight)
        for (i in 0 until numColumns) {
            for (j in 0 until numRows) {
                if (cellChecked[i][j]) {
                    canvas.drawRect(
                        (i * cellWidth).toFloat(), (j * cellHeight).toFloat(),
                        ((i + 1) * cellWidth).toFloat(), ((j + 1) * cellHeight).toFloat(),
                        blackPaint
                    )   //to fill the square
                }
            }
        }
        for (i in 1 until numColumns) {
            canvas.drawLine(
                (i * cellWidth).toFloat(), 0F,
                (i * cellWidth).toFloat(), height.toFloat(), blackPaint
            )
        }
        for (i in 1 until numRows) {
            canvas.drawLine(
                0F, (i * cellHeight).toFloat(),
                width.toFloat(), (i * cellHeight).toFloat(), blackPaint
            )
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val column = (event.x / cellWidth).toInt()
            val row = (event.y / cellHeight).toInt()
            cellChecked[column][row] = !cellChecked[column][row]
            invalidate()
        }
        return true
    }

    init {
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE)
    }
}