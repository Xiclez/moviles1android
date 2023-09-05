package com.example.pdm123.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.pdm123.R

@Composable
fun EvenOddView(navController: NavController, viewModel: EvenOddViewModel) {
    // Esta variable va a almacenar el valor de la caja de texto
    var txtNumber by remember { mutableStateOf("") }
    val evenOddState by viewModel.getEvenOddState().observeAsState(R.string.even_odd_empty_state)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.even_or_odd))
        TextField(
            value = txtNumber,
            onValueChange = { newValue ->
                // Actualizar el valor del TextField
                txtNumber = newValue

                // Verificar si el valor es un número entero o no
                val isInteger = newValue.matches("^-?\\d+$".toRegex())
                if (isInteger) {
                    val number = newValue.toInt()
                    // Llamar al método para calcular en el ViewModel
                    viewModel.calculateEvenOdd(EvenOdd(number))
                } else if (newValue.isEmpty()) {
                    // Mostrar un mensaje si el TextField está vacío
                    viewModel.calculateEvenOdd(EvenOdd(null))
                } else {
                    // Mostrar un mensaje de error si no es un número entero
                    viewModel.calculateEvenOdd(EvenOdd(-1))
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        // Mostrar mensajes en función del estado
        Text(text = stringResource(id = evenOddState))

        }
    }
}
