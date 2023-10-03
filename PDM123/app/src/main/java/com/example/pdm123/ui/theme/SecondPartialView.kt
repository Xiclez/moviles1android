package com.example.pdm123.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.ui.res.stringResource
import com.example.pdm123.R

@Composable
fun SecondPartialView(navController : NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(id = R.string.second_partial))

        Button(onClick = { navController.navigate(route = "lists") }) {
            Text(text = stringResource(id = R.string.lists))
        }
    }
}