package com.example.pdm123.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.*
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.pdm123.R

@Composable
fun FirstPartialView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = stringResource(id = R.string.first_partial),
            color = MaterialTheme.colors.secondary
        )
        Button(onClick = { navController.navigate(route = "padelScore") }) {
            Text(text = stringResource(id = R.string.padel_score))
        }
        Button(onClick = { navController.navigate(route = "evenodd") }) {
            Text(text = stringResource(id = R.string.even_or_odd))
        }
        Button(onClick = { navController.navigate(route = "cards") }) {
            Text(text = stringResource(id =R.string.cards))

        }
    }
}