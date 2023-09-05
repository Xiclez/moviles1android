package com.example.pdm123

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.graphics.Color
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.*
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pdm123.ui.theme.EvenOddView
import com.example.pdm123.ui.theme.EvenOddViewModel
import com.example.pdm123.ui.theme.FirstPartialView
import com.example.pdm123.ui.theme.NavBarItems
import com.example.pdm123.ui.theme.PDM123Theme
import com.example.pdm123.ui.theme.PadelScoreView
import com.example.pdm123.ui.theme.SecondPartialView
import com.example.pdm123.ui.theme.ThirdPartialView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PDM123Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = { Text("ULSA CHIHUAHUA") }) },
        content = {
            it
            NavigationHost(navController = navController)
        },
        bottomBar = { BottomNavigationBar(navController = navController) }
    )
}

/*
Esta funcion va a ser encargada de manejar los tabs de la aplicacion
 */
@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoutes.firstPartial.route) {
        composable(NavRoutes.firstPartial.route) {
            FirstPartialView(navController = navController)
        }
        composable(NavRoutes.secondPartial.route) {
            SecondPartialView()
        }
        composable(NavRoutes.thirdPartial.route) {
            ThirdPartialView()
        }
        composable(NavRoutes.padelScore.route) {
            PadelScoreView()
        }
        composable(NavRoutes.evenodd.route) {
            EvenOddView(navController = navController,viewModel = EvenOddViewModel())
        }

    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.NavBarItems.forEach { navItem ->

            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },

                icon = {
                    Icon(
                        imageVector = navItem.image,
                        contentDescription = navItem.toString()
                    )
                },
                label = {
                    Text(text = stringResource(id = navItem.title))
                }
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PDM123Theme {
        MainScreen()
    }
}
