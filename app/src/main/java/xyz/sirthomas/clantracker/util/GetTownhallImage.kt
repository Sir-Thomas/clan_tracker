package xyz.sirthomas.clantracker.util

import androidx.annotation.DrawableRes
import xyz.sirthomas.clantracker.R

@DrawableRes
fun getTownhallImage(townHall: Int?, weapon: Int? = null): Int {
    return when (townHall) {
        1 -> R.drawable.townhall_1
        2 -> R.drawable.townhall_2
        3 -> R.drawable.townhall_3
        4 -> R.drawable.townhall_4
        5 -> R.drawable.townhall_5
        6 -> R.drawable.townhall_6
        7 -> R.drawable.townhall_7
        8 -> R.drawable.townhall_8
        9 -> R.drawable.townhall_9
        10 -> R.drawable.townhall_10
        11 -> R.drawable.townhall_11
        12 -> {
            when (weapon) {
                1 -> R.drawable.townhall_12_1
                2 -> R.drawable.townhall_12_2
                3 -> R.drawable.townhall_12_3
                4 -> R.drawable.townhall_12_4
                else -> R.drawable.townhall_12_5
            }
        }
        13 -> {
            when (weapon) {
                1 -> R.drawable.townhall_13_1
                2 -> R.drawable.townhall_13_2
                3 -> R.drawable.townhall_13_3
                4 -> R.drawable.townhall_13_4
                else -> R.drawable.townhall_13_5
            }
        }
        14 -> {
            when (weapon) {
                1 -> R.drawable.townhall_14_1
                2 -> R.drawable.townhall_14_2
                3 -> R.drawable.townhall_14_3
                4 -> R.drawable.townhall_14_4
                else -> R.drawable.townhall_14_5
            }
        }
        15 -> {
            when (weapon) {
                1 -> R.drawable.townhall_15_1
                2 -> R.drawable.townhall_15_2
                3 -> R.drawable.townhall_15_3
                4 -> R.drawable.townhall_15_4
                else -> R.drawable.townhall_15_5
            }
        }
        else -> R.drawable.townhall_1
    }
}