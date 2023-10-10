package com.example.pdm123.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pdm123.R

@Composable
fun SecondPartialView(navController : NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.second_partial))
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.navigate(route = "onboarding") }) {
            Text(text = "Onboarding")}
            Button(onClick = { navController.navigate(route = "qr") }) {
                Text(text = "QR")}
                Button(onClick = { navController.navigate(route = "lists") }) {
                    Text(text = stringResource(id = R.string.lists))
                }

        
    }
}