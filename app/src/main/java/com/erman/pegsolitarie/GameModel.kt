package com.erman.pegsolitarie

import android.util.Log

fun canMove(cells: Array<IntArray>, rowFirst: Int, columnFirst: Int, rowSecond: Int, columnSecond: Int): Boolean {
    /*Log.w(
        "columnFirst",
        columnFirst.toString() + " rowFirst: " + rowFirst + " columnSecond: " + columnSecond + " rowSecond: " + rowSecond
    )*/
    if (rowFirst - 1 >= 0 && cells[columnFirst][rowFirst] == 1 && cells[columnFirst][rowFirst - 1] == 1 && cells[columnSecond][rowSecond] == 0 && rowFirst - rowSecond == 2 /*move up*/) {
        cells[columnFirst][rowFirst - 1] = 0
        cells[columnSecond][rowSecond] = 1
        cells[columnFirst][rowFirst] = 0
        return true
    } else if (rowFirst + 1 < cells.size && cells[columnFirst][rowFirst] == 1 && cells[columnFirst][rowFirst + 1] == 1 && cells[columnSecond][rowSecond] == 0 && rowSecond - rowFirst == 2 /*move down*/) {
        cells[columnFirst][rowFirst + 1] = 0
        cells[columnSecond][rowSecond] = 1
        cells[columnFirst][rowFirst] = 0
        return true
    } else if (columnFirst + 1 < cells.size && cells[columnFirst][rowFirst] == 1 && cells[columnFirst + 1][rowFirst] == 1 && cells[columnSecond][rowSecond] == 0 && columnSecond - columnFirst == 2 /*move right*/) {
        cells[columnFirst + 1][rowFirst] = 0
        cells[columnSecond][rowSecond] = 1
        cells[columnFirst][rowFirst] = 0
        return true
    } else if (columnFirst - 1 >= 0 && cells[columnFirst][rowFirst] == 1 && cells[columnFirst - 1][rowFirst] == 1 && cells[columnSecond][rowSecond] == 0 && columnFirst - columnSecond == 2 /*move left*/) {
        cells[columnFirst - 1][rowFirst] = 0
        cells[columnSecond][rowSecond] = 1
        cells[columnFirst][rowFirst] = 0
        return true
    }
    return false
}

fun isGameOver(cells: Array<IntArray>): Boolean {
    for (column in cells.indices) {
        for (row in cells[column].indices) {
            if (cells[column][row] != -1) {
                if (row - 1 >= 0 && row - 2 >= 0 && cells[column][row] == 1 && cells[column][row - 1] == 1 && cells[column][row - 2] == 0/*east*/) {
                    return false
                } else if (row + 1 < cells[column].size && row + 2 < cells.size && cells[column][row] == 1 && cells[column][row + 1] == 1 && cells[column][row + 2] == 0 /*south*/) {
                    return false
                } else if (column + 1 < cells.size && column + 2 < cells.size && cells[column][row] == 1 && cells[column + 1][row] == 1 && cells[column + 2][row] == 0 /*east*/) {
                    return false
                } else if (column - 1 >= 0 && column - 2 >= 0 && cells[column][row] == 1 && cells[column - 1][row] == 1 && cells[column - 2][row] == 0 /*west*/) {
                    return false
                }
            }
        }
    }
    return true
}