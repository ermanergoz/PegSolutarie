package com.erman.pegsolitarie

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

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
    private val blackPaint: Paint = Paint()
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

        drawGridLines(canvas)
        paintCorners(canvas)
        paintCell(canvas)
    }

    private fun paintCorners(canvas: Canvas) {
        for (i in cells.indices) {
            for (j in cells[i].indices) {
                if (cells[i][j] == -1)
                    canvas.drawRect(
                        (i * (cellWidth + 0.2)).toFloat(), (j * (cellHeight + 0.2)).toFloat(),
                        ((i + 1) * (cellWidth + 0.2)).toFloat(), ((j + 1) * (cellHeight + 0.2)).toFloat(),
                        cornerPaint
                    )
            }
        }
    }

    private fun drawGridLines(canvas: Canvas) {
        for (i in 0 until numColumns + 1) {
            canvas.drawLine(
                (i * cellWidth).toFloat(), 0F,
                (i * cellWidth).toFloat(), height.toFloat(), blackPaint
            )
        }
        for (i in 0 until numRows + 1) {
            canvas.drawLine(
                0F, (i * cellHeight).toFloat(),
                width.toFloat(), (i * cellHeight).toFloat(), blackPaint
            )
        }
    }

    private fun paintCell(canvas: Canvas) {
        for (i in 0 until numColumns) {
            for (j in 0 until numRows) {
                if (cells[i][j] == 1 && cells[i][j] != -1) {
                    val centerX = (((i * cellWidth) + (((i + 1) * cellWidth))) / 2).toFloat()
                    val centerY = (((j * cellHeight) + (((j + 1) * cellHeight))) / 2).toFloat()

                    val radius = if (cellWidth < cellHeight)
                        (cellWidth / 2).toFloat()
                    else (cellHeight / 2).toFloat()

                    canvas.drawCircle(centerX, centerY, radius, blackPaint)
                }
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
                else if(cells[column][row] != -1)
                    cells[column][row] = 1

                invalidate()
            }
        }
        return true
    }

    init {
        cornerPaint.color = Color.WHITE
        blackPaint.style = Paint.Style.FILL_AND_STROKE
    }
}