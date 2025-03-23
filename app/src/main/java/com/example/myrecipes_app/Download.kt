package com.example.myrecipes_app

import androidx.compose.runtime.Composable
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.draw.clip

@Composable
fun Download()
{
    Box(modifier = Modifier.fillMaxSize())
    {
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
                    .background(
                        color = Color(0xFFFFFFFF),
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(
                            color = Color(0xFFF5F5F5),
                        )
                        .verticalScroll(rememberScrollState())
                ) {
                    Column(
                        modifier = Modifier
                            .padding(bottom = 8.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                    ){
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 4.dp,)
                                .clip(shape = RoundedCornerShape(18.dp))
                                .fillMaxWidth()
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(18.dp)
                                )
                                .padding(vertical = 29.dp,)
                        ){
                            Text("Напишите название блюда",
                                color = Color(0xFF4B4B4B),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 11.dp,start = 28.dp,)
                            )
                            Text("Например: паста с чоризо",
                                color = Color(0xFF9B9B9B),
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(bottom = 12.dp,start = 29.dp,)
                            )
                            Text("Добавьте изображения (минимум 3)",
                                color = Color(0xFF4B4B4B),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 11.dp,start = 28.dp,)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(start = 28.dp,)
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.add_photo), //фото
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(end = 8.dp,)
                                        .clip(shape = RoundedCornerShape(18.dp))
                                        .width(48.dp)
                                        .height(48.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.photo), //фото
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(end = 8.dp,)
                                        .clip(shape = RoundedCornerShape(18.dp))
                                        .width(48.dp)
                                        .height(48.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.photo), //фото
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(end = 8.dp,)
                                        .clip(shape = RoundedCornerShape(18.dp))
                                        .width(48.dp)
                                        .height(48.dp)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.photo), //фото
                                    contentDescription = null,
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(18.dp))
                                        .width(48.dp)
                                        .height(48.dp)
                                )
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .padding(bottom = 8.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                    ){
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 4.dp,)
                                .clip(shape = RoundedCornerShape(18.dp))
                                .fillMaxWidth()
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(18.dp)
                                )
                                .padding(vertical = 29.dp,)
                        ){
                            Text("Сколько длится подготовка для приготовления",
                                color = Color(0xFF4B4B4B),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 10.dp,start = 28.dp,)
                            )
                            Text("Например: 10мин",
                                color = Color(0xFF9B9B9B),
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(bottom = 14.dp,start = 29.dp,)
                            )
                            Text("Сколько длится готовка блюда",
                                color = Color(0xFF4B4B4B),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 10.dp,start = 28.dp,)
                            )
                            Text("Например: 10мин",
                                color = Color(0xFF9B9B9B),
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(bottom = 13.dp,start = 29.dp,)
                            )
                            Text("Какая сложность блюда ( от 0 до 5 )",
                                color = Color(0xFF4B4B4B),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 11.dp,start = 28.dp,)
                            )
                            Text("Например: 2",
                                color = Color(0xFF9B9B9B),
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(bottom = 14.dp,start = 29.dp,)
                            )
                            Text("Сколько порций у такого блюда",
                                color = Color(0xFF4B4B4B),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 10.dp,start = 28.dp,)
                            )
                            Text("Например: 3",
                                color = Color(0xFF9B9B9B),
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(bottom = 15.dp,start = 29.dp,)
                            )
                            Text("Ингредиенты",
                                color = Color(0xFF4B4B4B),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 8.dp,start = 28.dp,)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(bottom = 6.dp,start = 28.dp,)
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.gray_plus), //убрать ингредиент
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(end = 8.dp,)
                                        .width(24.dp)
                                        .height(24.dp)
                                )
                                Text("Добавить ингредиент",
                                    color = Color(0xFF9B9B9B),
                                    fontSize = 14.sp,
                                    modifier = Modifier
                                        .padding(vertical = 7.dp,)
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(bottom = 4.dp,start = 29.dp,end = 29.dp,)
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp,)
                            ){
                                Text("Пармезан (тертый) - 120 г",
                                    color = Color(0xFF4B4B4B),
                                    fontSize = 14.sp,
                                    modifier = Modifier
                                        .weight(1f)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.delete), //убрать ингредиент
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(24.dp)
                                        .height(24.dp)
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(bottom = 4.dp,start = 29.dp,end = 29.dp,)
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp,)
                            ){
                                Text("Паста (пенне) - 1600 г",
                                    color = Color(0xFF4B4B4B),
                                    fontSize = 14.sp,
                                    modifier = Modifier
                                        .weight(1f)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.delete), //убрать ингредиент
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(24.dp)
                                        .height(24.dp)
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(bottom = 4.dp,start = 29.dp,end = 29.dp,)
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp,)
                            ){
                                Text("Пармезан (тертый) - 120 г",
                                    color = Color(0xFF4B4B4B),
                                    fontSize = 14.sp,
                                    modifier = Modifier
                                        .weight(1f)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.delete), //убрать ингредиент
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(24.dp)
                                        .height(24.dp)
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(bottom = 11.dp,start = 29.dp,end = 29.dp,)
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp,)
                            ){
                                Text("Паста (пенне) - 1600 г",
                                    color = Color(0xFF4B4B4B),
                                    fontSize = 14.sp,
                                    modifier = Modifier
                                        .weight(1f)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.delete), //убрать ингредиент
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(24.dp)
                                        .height(24.dp)
                                )
                            }
                            Text("Способ приготовления",
                                color = Color(0xFF4B4B4B),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 10.dp,start = 28.dp,)
                            )
                            Text("Напишите способ приготовления...",
                                color = Color(0xFF9B9B9B),
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(start = 29.dp,)
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(120.dp))
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                    ){
                        OutlinedButton(
                            onClick = { println("Pressed!") },
                            border = BorderStroke(0.dp, Color.Transparent),
                            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
                            contentPadding = PaddingValues(),
                            modifier = Modifier
                                .padding(horizontal = 4.dp,)
                                .clip(shape = RoundedCornerShape(120.dp))
                                .fillMaxWidth()
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(120.dp)
                                )
                        ){
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(vertical = 18.dp,horizontal = 124.dp,)
                            ){
                                Text("Загрузить блюдо",
                                    color = Color(0xFF4B4B4B),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .weight(1f)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.next), //загрузить видео
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(24.dp)
                                        .height(24.dp)
                                )
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
//                        Text(
//                            "Рецепты",
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
//                                    color = Color(0xFFFFFFFF),
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
//                                    color = Color(0xFFD1D1D1),
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
//
//                }
            }
        }
    }

}

