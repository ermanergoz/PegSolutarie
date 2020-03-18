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

    val gameCorners: Array<IntArray> = Array(7) { IntArray(7) }

    gameCorners[0][0] = -1
    gameCorners[0][1] = -1
    gameCorners[1][0] = -1
    gameCorners[1][1] = -1

    gameCorners[5][0] = -1
    gameCorners[6][0] = -1
    gameCorners[5][1] = -1
    gameCorners[6][1] = -1

    gameCorners[5][5] = -1
    gameCorners[6][5] = -1  //TODO: Change these nasty stuff
    gameCorners[5][6] = -1
    gameCorners[6][6] = -1

    gameCorners[5][5] = -1
    gameCorners[6][5] = -1
    gameCorners[5][6] = -1
    gameCorners[6][6] = -1

    gameCorners[0][5] = -1
    gameCorners[1][5] = -1
    gameCorners[0][6] = -1
    gameCorners[1][6] = -1

    return GridView(context, screenWidth, screenHeight,gameCorners, null)
}