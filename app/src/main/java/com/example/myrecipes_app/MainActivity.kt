package com.example.myrecipes_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import com.example.myrecipes_app.ui.theme.Myrecipes_appTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavController
import androidx.navigation.compose.*
import androidx.compose.ui.res.painterResource  // для painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp  // для 16.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController  // для NavController
import androidx.navigation.compose.rememberNavController  // для NavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Myrecipes_appTheme {
                AppNavigation()
            }
        }
    }
}
sealed class Screen(val route: String) {
    object MainRecipes : Screen("main_recipes")
    object Purchases : Screen("purchases")
    object Favorites : Screen("favorites")
    object Download : Screen("download")
}


@Composable
fun MainRecipesScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Экран рецептов", fontSize = 20.sp)

        Button(onClick = {
            navController.navigate("dish_recipes/123") // Переход на экран с id блюда
        }) {
            Text("Перейти на рецепт")
        }
    }
}


@Composable
fun AppNavigation() {
    val navController = rememberNavController()  // создаем контроллер навигации

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }  // нижняя панель
    ) { paddingValues ->
        // NavHost обрабатывает навигацию
        NavHost(
            navController = navController,
            startDestination = Screen.MainRecipes.route,  // начальный экран
            modifier = Modifier.padding(paddingValues)
        ) {
            // Здесь мы определяем маршруты для каждого экрана
            composable(Screen.MainRecipes.route) { Main_recipes() }
            composable(Screen.Purchases.route) { Purchases() }
            composable(Screen.Favorites.route) { Favorites() }
            composable(Screen.Download.route) { Download() }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentRoute = currentRoute(navController)  // Получаем текущий маршрут

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(bottom = 8.dp, start = 3.dp, end = 3.dp)
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF)) // Светлый фон
    ) {
        val icons = listOf(
            "Рецепты" to R.drawable.burger_podval,
            "Покупки" to R.drawable.pokupki,
            "Избранное" to R.drawable.bookmark,
            "Загрузить" to R.drawable.download
        )

        icons.forEach { (label, iconId) ->
            val isSelected = currentRoute == when (label) {
                "Рецепты" -> Screen.MainRecipes.route
                "Покупки" -> Screen.Purchases.route
                "Избранное" -> Screen.Favorites.route
                "Загрузить" -> Screen.Download.route
                else -> null
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 10.dp, horizontal = 13.dp)
                    .clickable {
                        when (label) {
                            "Рецепты" -> navController.navigate(Screen.MainRecipes.route)
                            "Покупки" -> navController.navigate(Screen.Purchases.route)
                            "Избранное" -> navController.navigate(Screen.Favorites.route)
                            "Загрузить" -> navController.navigate(Screen.Download.route)
                        }
                    }
            ) {
                val iconColor = if (isSelected) Color.DarkGray else Color.Gray

                Image(
                    painter = painterResource(id = iconId),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(bottom = 3.dp)
                        .size(32.dp),
                    colorFilter = ColorFilter.tint(iconColor)
                )

                Text(
                    label,
                    color = if (isSelected) Color.DarkGray else Color.Gray,
                    fontSize = 13.3.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val currentBackStackEntry = navController.currentBackStackEntryAsState().value
    return currentBackStackEntry?.destination?.route  // Получаем текущий маршрут
}

