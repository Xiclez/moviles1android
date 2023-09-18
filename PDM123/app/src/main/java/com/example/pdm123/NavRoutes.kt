package com.example.pdm123
/*
Lista de rutas a las cuales se puede navegar dentro de la aplicacion
 */
sealed class NavRoutes(val route: String) {
    object firstPartial : NavRoutes("firstPartial")
    object secondPartial : NavRoutes("secondPartial")
    object thirdPartial : NavRoutes("thirdPartial")
    object padelScore : NavRoutes("padelScore")
    object evenodd : NavRoutes("evenodd")
    object cards : NavRoutes("cards")
    object numComparator : NavRoutes("numComparator")
    object barber : NavRoutes("barber")
    object firstPartialTest : NavRoutes("firstTest")
}