package com.example.myrecipes_app

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// Модель данных для рецепта
data class Favorites(
    val name: String,
    val imageResId: Int,
    val id: Int = (0..10000).random()
)

// ViewModel для управления избранными рецептами
class FavoritesViewModel : ViewModel() {
    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    init {
        loadInitialRecipes()
    }

    private fun loadInitialRecipes() {
        val initialList = listOf(
            Recipe("Паста с чоризо", R.drawable.pasta_with_chorizo),
            Recipe("Брауни с шоколадом", R.drawable.brauni),
            Recipe("Ягодный пирог", R.drawable.yagodniy_pirog),
            Recipe("Паста карбонара", R.drawable.pasta_carbonara),
            Recipe("Пышные оладушки на кефире", R.drawable.oladushki),
            Recipe("Курица в кисло сладком соусе", R.drawable.chicken_carri)
        )
        _recipes.value = initialList
    }

    fun updateSearchQuery(query: String) {
        viewModelScope.launch {
            _searchQuery.value = query
            filterRecipes(query)
        }
    }

    private fun filterRecipes(query: String) {
        val initialList = listOf(
            Recipe("Паста с чоризо", R.drawable.pasta_with_chorizo),
            Recipe("Брауни с шоколадом", R.drawable.brauni),
            Recipe("Ягодный пирог", R.drawable.yagodniy_pirog),
            Recipe("Паста карбонара", R.drawable.pasta_carbonara),
            Recipe("Пышные оладушки на кефире", R.drawable.oladushki),
            Recipe("Курица в кисло сладком соусе", R.drawable.chicken_carri)
        )
        _recipes.value = if (query.isEmpty()) {
            initialList
        } else {
            initialList.filter { it.name.contains(query, ignoreCase = true) }
        }
    }
}

// Компонента Favorites
@Composable
fun Favorites(viewModel: FavoritesViewModel = viewModel()) {
    val recipes by viewModel.recipes.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(top = 3.dp)
                .fillMaxSize()
                .background(color = Color(0xFFF5F5F5))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = Color(0xFFFFFFFF))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(color = Color(0xFFF5F5F5))
                        .verticalScroll(rememberScrollState())
                ) {
                    // Поле поиска
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(120.dp))
                            .background(Color.White)
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Поиск",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        TextField(
                            value = searchQuery,
                            onValueChange = { viewModel.updateSearchQuery(it) },
                            placeholder = { Text("Найти рецепт...", color = Color.Gray) },
                            modifier = Modifier
                                .weight(1f)
                                .background(Color.Transparent),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.Black
                            ),
                            textStyle = LocalTextStyle.current.copy(fontSize = 16.sp)
                        )
                    }

                    // Категории
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(18.dp))
                            .padding(vertical = 16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .fillMaxWidth()
                        ) {
                            listOf(
                                "Завтрак" to R.drawable.bread,
                                "Каши" to R.drawable.zerno,
                                "Основные" to R.drawable.main_dish,
                                "Салаты" to R.drawable.salade,
                                "Супы" to R.drawable.soop
                            ).forEach { (text, icon) ->
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Image(painterResource(id = icon), null, Modifier.size(24.dp))
                                    Text(text, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4B4B4B))
                                }
                            }
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(horizontal = 26.dp)
                                .fillMaxWidth()
                        ) {
                            listOf(
                                "Птица" to R.drawable.chicken_sort,
                                "Мясо" to R.drawable.meet,
                                "Необычное" to R.drawable.burger,
                                "Десерты" to R.drawable.ice,
                                "Выпечка" to R.drawable.pancake
                            ).forEach { (text, icon) ->
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Image(painterResource(id = icon), null, Modifier.size(24.dp))
                                    Text(text, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4B4B4B))
                                }
                            }
                        }
                    }

                    // Список рецептов
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                            .fillMaxWidth()
                    ) {
                        recipes.chunked(2).forEach { rowRecipes ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                rowRecipes.forEachIndexed { index, recipe ->
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(if (index == 0) 0.dp else 4.dp)
                                            .clip(RoundedCornerShape(14.dp))
                                    ) {
                                        Image(
                                            painter = painterResource(id = recipe.imageResId),
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxWidth(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.zametka_izbr),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(48.dp)
                                                .align(Alignment.TopEnd)
                                                .padding(8.dp)
                                        )
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 150.dp, bottom = 12.dp)
                                                .align(Alignment.BottomCenter)
                                        ) {
                                            Text(
                                                text = recipe.name,
                                                color = Color.White,
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Bold,
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.padding(horizontal = 8.dp)
                                            )
                                        }
                                    }
                                }
                                if (rowRecipes.size == 1) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                }





//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color(0xFFFFFFFF))
//                        .padding(vertical = 21.dp, horizontal = 23.dp)
//                ) {
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        modifier = Modifier.weight(1f) // Применяем вес для равномерного распределения
//                    ) {
//                        Column(
//                            modifier = Modifier
//                                .padding(bottom = 10.dp)
//                                .clip(shape = RoundedCornerShape(44.dp))
//                                .background(
//                                    color = Color(0xFFFFFFFF),
//                                    shape = RoundedCornerShape(44.dp)
//                                )
//                                .padding(horizontal = 11.dp)
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.burger_podval), // burger_main
//                                contentDescription = null,
//                                modifier = Modifier
//                                    .width(24.dp)
//                                    .height(24.dp)
//                            )
//                        }
//                        Text("Рецепты",
//                            color = Color(0xFF4B4B4B),
//                            fontSize = 12.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                    }
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        modifier = Modifier.weight(1f) // Применяем вес для равномерного распределения
//                    ) {
//                        Column(
//                            modifier = Modifier
//                                .padding(bottom = 10.dp)
//                                .clip(shape = RoundedCornerShape(44.dp))
//                                .background(
//                                    color = Color(0xFFFFFFFF),
//                                    shape = RoundedCornerShape(44.dp)
//                                )
//                                .padding(horizontal = 11.dp)
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.pokupki), // покупки
//                                contentDescription = null,
//                                modifier = Modifier
//                                    .width(24.dp)
//                                    .height(24.dp)
//                            )
//                        }
//                        Text(
//                            "Покупки",
//                            color = Color(0xFF4B4B4B),
//                            fontSize = 12.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                    }
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        modifier = Modifier.weight(1f) // Применяем вес для равномерного распределения
//                    ) {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier
//                                .padding(bottom = 9.dp, start = 8.dp, end = 8.dp)
//                                .clip(shape = RoundedCornerShape(44.dp))
//                                .background(
//                                    color = Color(0xFFD1D1D1),
//                                    shape = RoundedCornerShape(44.dp)
//                                )
//                                .padding(horizontal = 11.dp)
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.bookmark), // избранное
//                                contentDescription = null,
//                                modifier = Modifier
//                                    .width(24.dp)
//                                    .height(24.dp)
//                            )
//                        }
//                        Text(
//                            "Избранное",
//                            color = Color(0xFF4B4B4B),
//                            fontSize = 12.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                    }
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        modifier = Modifier.weight(1f) // Применяем вес для равномерного распределения
//                    ) {
//                        Column(
//                            modifier = Modifier
//                                .padding(bottom = 10.dp)
//                                .clip(shape = RoundedCornerShape(44.dp))
//                                .background(
//                                    color = Color(0xFFFFFFFF),
//                                    shape = RoundedCornerShape(44.dp)
//                                )
//                                .padding(horizontal = 11.dp)
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.download), // Загрузить
//                                contentDescription = null,
//                                modifier = Modifier
//                                    .width(24.dp)
//                                    .height(24.dp)
//                            )
//                        }
//                        Text(
//                            "Загрузить",
//                            color = Color(0xFF4B4B4B),
//                            fontSize = 12.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                    }
//                }
//
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(
//                            color = Color(0xFFF5F5F5),
//                        )
//                        .padding(vertical = 10.dp,)
//                ) {
//                }
            }
        }

    }
}


