package com.erman.pegsolitarie

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat.getColor

class GridView(
    context: Context?,
    private var screenWidth: Int,
    private var screenHeight: Int,
    private var cells: Array<IntArray>,
    attrs: AttributeSet?
) :
    View(context, attrs) {

    private var cellWidth = 0
    private var cellHeight = 0
    private val pegPaint: Paint = Paint()
    private val pegSlotPaint: Paint = Paint()
    private val pegSlotWidth: Float = 10F
    private val pegMargin: Float = 5F
    private val cornerPaint: Paint = Paint()
    private var numColumns: Int = cells.size
    private var numRows: Int = cells[0].size

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
        paintCells(canvas)
    }

    private fun paintCells(canvas: Canvas) {
        for (i in 0 until numColumns) {
            for (j in 0 until numRows) {

                val centerX = (((i * cellWidth) + (((i + 1) * cellWidth))) / 2).toFloat()
                val centerY = (((j * cellHeight) + (((j + 1) * cellHeight))) / 2).toFloat()

                val radius = if (cellWidth < cellHeight)
                    (cellWidth / 2).toFloat()
                else (cellHeight / 2).toFloat()

                if (cells[i][j] == 1 && cells[i][j] != -1)
                    canvas.drawCircle(centerX, centerY, radius-pegMargin, pegPaint)
                else if (cells[i][j] == 0 && cells[i][j] != -1)
                    canvas.drawCircle(centerX, centerY, radius-pegSlotWidth-pegMargin, pegSlotPaint)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val column = (event.x / cellWidth).toInt()
            val row = (event.y / cellHeight).toInt()

            if (row < numRows && column < numColumns) {
                if (cells[column][row] == 1 && cells[column][row] != -1)
                    cells[column][row] = 0
                else if (cells[column][row] != -1)
                    cells[column][row] = 1

                invalidate()
            }
        }
        return true
    }

    init {
        cornerPaint.color = Color.WHITE
        pegPaint.color = getColor(context!!, R.color.pegColor)
        pegPaint.style = Paint.Style.FILL_AND_STROKE
        pegSlotPaint.style = Paint.Style.STROKE
        pegSlotPaint.strokeWidth = pegSlotWidth
        pegSlotPaint.color = getColor(context, R.color.pegSlotColor)
    }
}