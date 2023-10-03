package com.example.pdm123.ui.theme

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Pokemon(val nombre: String, val altura: String, val tipo: String)

private val PokeList = listOf(
    Pokemon(
        "Charmander",
        "0.4m",
        "fuego"
    ),
    Pokemon(
        "Squirtle",
        "0.5m",
        "agua"
    ),
    Pokemon(
        "Pidgeot",
        "1.5m",
        "Normal"
    ),
    Pokemon(
        "Kakuna",
        "0.6m",
        "bicho"
    ),
    Pokemon(
        "Arbok",
        "3.5m",
        "Veneno"
    )
)

@Composable
fun DesignPoke(pokemon: Pokemon) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = pokemon.nombre,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Text(
            text = pokemon.altura,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Text(
            text = pokemon.tipo,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Composable
fun ListView() {
    LazyColumn(
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        item {
            Text(
                text = "Pokemons",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Black
                )
            )
        }
        items(PokeList){
            DesignPoke(pokemon = it)
        }
    }
}