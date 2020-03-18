package com.erman.pegsolitarie

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.View

private const val gameGridHolderHeightOffset = 160f

fun constructEnglishBoard(context: Context): View {
    val px = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        gameGridHolderHeightOffset,
        context.resources.displayMetrics
    )

    val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    val screenHeight = Resources.getSystem().displayMetrics.heightPixels - px.toInt()

    val cells: Array<IntArray> = arrayOf(
        intArrayOf(-1, -1, 1, 1, 1, -1, -1),
        intArrayOf(-1, -1, 1, 1, 1, -1, -1),
        intArrayOf(1, 1, 1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 0, 1, 1, 1),
        intArrayOf(1, 1, 1, 1, 1, 1, 1),
        intArrayOf(-1, -1, 1, 1, 1, -1, -1),
        intArrayOf(-1, -1, 1, 1, 1, -1, -1)
    )   //-1 is dead cell, 1 is peg, 0 is empty

    return GridView(context, screenWidth, screenHeight, cells, null)
}