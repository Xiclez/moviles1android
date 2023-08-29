package com.example.pdm123.ui.theme

import androidx.compose.ui.graphics.vector.ImageVector

/*Esta es una clase de datos para los elementos del menu que aparece abajo
 */
data class BarItem(
    //Titulo de la opcion
    val title: Int,
    //Icono de la opcion del menu
    val image: ImageVector,
    //Ruta a la cual se va a dirigir la opción
    val route: String
)
