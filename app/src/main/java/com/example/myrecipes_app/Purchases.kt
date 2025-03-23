package com.example.myrecipes_app

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.draw.clip
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


data class Ingredient(
    val name: String,
    val quantity: String,
    val id: Int = (0..10000).random()
)

class PurchasesViewModel : ViewModel() {
    private val _ingredients = MutableStateFlow<List<Ingredient>>(emptyList())
    val ingredients: StateFlow<List<Ingredient>> = _ingredients

    init {
        loadInitialIngredients()
    }

    private fun loadInitialIngredients() {
        val initialList = listOf(
            Ingredient("Чоризо", "4 шт"),
            Ingredient("Оливковое масло", "4 ст. л."),
            Ingredient("Красный лук", "4 шт."),
            Ingredient("Чеснок", "4 зубчика"),
            Ingredient("Белое вино (сухое)", "400 мл"),
            Ingredient("Томатная паста", "8 ст. л."),
            Ingredient("Орегано", "4 ст. л."),
            Ingredient("Базилик", "2 пучка"),
            Ingredient("Сливки", "800 мл"),
            Ingredient("Вода от варки пасты", "8 половника"),
            Ingredient("Паста (пенне)", "1600 г"),
            Ingredient("Пармезан (тертый)", "120 г"),
            Ingredient("Страчателла", "600 г")
        )
        _ingredients.value = initialList
    }

    fun addIngredient(name: String, quantity: String) {
        viewModelScope.launch {
            val newIngredient = Ingredient(name, quantity)
            _ingredients.value = _ingredients.value + newIngredient
        }
    }

    fun removeIngredient(ingredientId: Int) {
        viewModelScope.launch {
            _ingredients.value = _ingredients.value.filter { it.id != ingredientId }
        }
    }
}

// Компонента Purchases
@Composable
fun Purchases(viewModel: PurchasesViewModel = viewModel()) {
    val ingredients by viewModel.ingredients.collectAsState()
    var newIngredientName by remember { mutableStateOf("") }
    var newIngredientQuantity by remember { mutableStateOf("") }

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
                    // Поля ввода и кнопка добавления
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedButton(
                            onClick = {
                                if (newIngredientName.isNotEmpty() && newIngredientQuantity.isNotEmpty()) {
                                    viewModel.addIngredient(newIngredientName, newIngredientQuantity)
                                    newIngredientName = ""
                                    newIngredientQuantity = ""
                                }
                            },
                            border = BorderStroke(0.dp, Color.Transparent),
                            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
                            modifier = Modifier
                                .padding(4.dp)
                                .clip(shape = RoundedCornerShape(120.dp))
                                .fillMaxWidth()
                                .background(color = Color(0xFFFFFFFF))
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(vertical = 11.dp, horizontal = 17.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.plus),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(end = 18.dp)
                                        .size(24.dp)
                                )
                                Text(
                                    text = "Добавить ингредиент",
                                    color = Color(0xFF4B4B4B),
                                    fontSize = 16.sp
                                )
                            }
                        }

                        // Поля ввода
                        TextField(
                            value = newIngredientName,
                            onValueChange = { newIngredientName = it },
                            label = { Text("Название") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        )
                        TextField(
                            value = newIngredientQuantity,
                            onValueChange = { newIngredientQuantity = it },
                            label = { Text("Количество") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        )
                    }

                    // Список ингредиентов
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        ingredients.forEach { ingredient ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .clip(shape = RoundedCornerShape(18.dp))
                                    .fillMaxWidth()
                                    .background(color = Color(0xFFFFFFFF))
                                    .padding(vertical = 10.dp, horizontal = 28.dp)
                            ) {
                                Text(
                                    text = "${ingredient.name} — ${ingredient.quantity}",
                                    color = Color(0xFF4B4B4B),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.weight(1f)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.sell),
                                    contentDescription = "Удалить",
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clickable { viewModel.removeIngredient(ingredient.id) }
                                )
                            }
                        }
                    }
                }




//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(Color(0xFFFFFFFF))
//                            .padding(vertical = 21.dp, horizontal = 23.dp)
//                    ) {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier.weight(1f) // Применяем вес для равномерного распределения
//                        ) {
//                            Column(
//                                modifier = Modifier
//                                    .padding(bottom = 10.dp)
//                                    .clip(shape = RoundedCornerShape(44.dp))
//                                    .background(
//                                        color = Color(0xFFFFFFFF),
//                                        shape = RoundedCornerShape(44.dp)
//                                    )
//                                    .padding(horizontal = 11.dp)
//                            ) {
//                                Image(
//                                    painter = painterResource(id = R.drawable.burger_podval), // burger_main
//                                    contentDescription = null,
//                                    modifier = Modifier
//                                        .width(24.dp)
//                                        .height(24.dp)
//                                )
//                            }
//                            Text(
//                                "Рецепты",
//                                color = Color(0xFF4B4B4B),
//                                fontSize = 12.sp,
//                                fontWeight = FontWeight.Bold
//                            )
//                        }
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier.weight(1f) // Применяем вес для равномерного распределения
//                        ) {
//                            Column(
//                                modifier = Modifier
//                                    .padding(bottom = 10.dp)
//                                    .clip(shape = RoundedCornerShape(44.dp))
//                                    .background(
//                                        color = Color(0xFFD1D1D1),
//                                        shape = RoundedCornerShape(44.dp)
//                                    )
//                                    .padding(horizontal = 11.dp)
//                            ) {
//                                Image(
//                                    painter = painterResource(id = R.drawable.pokupki), // покупки
//                                    contentDescription = null,
//                                    modifier = Modifier
//                                        .width(24.dp)
//                                        .height(24.dp)
//                                )
//                            }
//                            Text(
//                                "Покупки",
//                                color = Color(0xFF4B4B4B),
//                                fontSize = 12.sp,
//                                fontWeight = FontWeight.Bold
//                            )
//                        }
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier.weight(1f) // Применяем вес для равномерного распределения
//                        ) {
//                            Column(
//                                horizontalAlignment = Alignment.CenterHorizontally,
//                                modifier = Modifier
//                                    .padding(bottom = 9.dp, start = 8.dp, end = 8.dp)
//                                    .clip(shape = RoundedCornerShape(44.dp))
//                                    .background(
//                                        color = Color(0xFFFFFFFF),
//                                        shape = RoundedCornerShape(44.dp)
//                                    )
//                                    .padding(horizontal = 11.dp)
//                            ) {
//                                Image(
//                                    painter = painterResource(id = R.drawable.bookmark), // избранное
//                                    contentDescription = null,
//                                    modifier = Modifier
//                                        .width(24.dp)
//                                        .height(24.dp)
//                                )
//                            }
//                            Text(
//                                "Избранное",
//                                color = Color(0xFF4B4B4B),
//                                fontSize = 12.sp,
//                                fontWeight = FontWeight.Bold
//                            )
//                        }
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            modifier = Modifier.weight(1f) // Применяем вес для равномерного распределения
//                        ) {
//                            Column(
//                                modifier = Modifier
//                                    .padding(bottom = 10.dp)
//                                    .clip(shape = RoundedCornerShape(44.dp))
//                                    .background(
//                                        color = Color(0xFFFFFFFF),
//                                        shape = RoundedCornerShape(44.dp)
//                                    )
//                                    .padding(horizontal = 11.dp)
//                            ) {
//                                Image(
//                                    painter = painterResource(id = R.drawable.download), // Загрузить
//                                    contentDescription = null,
//                                    modifier = Modifier
//                                        .width(24.dp)
//                                        .height(24.dp)
//                                )
//                            }
//                            Text(
//                                "Загрузить",
//                                color = Color(0xFF4B4B4B),
//                                fontSize = 12.sp,
//                                fontWeight = FontWeight.Bold
//                            )
//                        }
//                    }
//
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(
//                                color = Color(0xFFF5F5F5),
//                            )
//                            .padding(vertical = 10.dp,)
//                    ) {
//
//                    }

            }
        }
    }
}
