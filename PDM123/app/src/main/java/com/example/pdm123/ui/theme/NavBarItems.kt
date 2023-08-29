package com.example.pdm123.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.example.pdm123.R

object NavBarItems {
    val NavBarItems = listOf(
        BarItem(
            title = R.string.first_partial,
            image = Icons.Filled.Atm,
            route = "firstPartial"
        ),
        BarItem(
            title = R.string.second_partial,
            image = Icons.Filled.AutoFixHigh,
            route = "secondPartial"
        ),
        BarItem(
            title = R.string.third_partial,
            image = Icons.Filled.Bloodtype,
            route = "thirdPartial"
        ),


    )



}