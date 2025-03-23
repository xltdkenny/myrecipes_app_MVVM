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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.draw.clip


@Composable
fun Dish_recipes() {
    Column(
        modifier = Modifier
            .padding(top = 3.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color(0xFFFFFFFF),
            )
    ){
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(28.dp))
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(28.dp)
                )
                .verticalScroll(rememberScrollState())
        ){

            Box{
                Image(
                    painter = painterResource(id = R.drawable.pasta_chorizo), //блюдо
                    contentDescription = null,
                    modifier = Modifier
                        .padding(bottom = 8.dp,)
                        .fillMaxWidth()
                )
                Column(
                    modifier = Modifier
                        .padding(bottom = 8.dp,)
                        .fillMaxWidth()
                        .padding(top = 9.dp,bottom = 225.dp,)
                ){
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 4.dp,)
                            .fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.back), //блюдо
                            contentDescription = null,
                            modifier = Modifier
                                .width(48.dp)
                                .height(48.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.zametka_izbr_vkl), //блюдо
                            contentDescription = null,
                            modifier = Modifier
                                .width(48.dp)
                                .height(48.dp)
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(bottom = 8.dp,)
                    .fillMaxWidth()
            ){
                Column(
                    modifier = Modifier
                        .padding(bottom = 8.dp,)
                        .fillMaxWidth()
                ){
                    Column(
                        modifier = Modifier
                            .padding(bottom = 4.dp,start = 4.dp,end = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(top = 19.dp,bottom = 8.dp,)
                    ){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(bottom = 11.dp,)
                                .fillMaxWidth()
                        ){
                            Text("Паста с чоризо",
                                color = Color(0xFF4B4B4B),
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(bottom = 4.dp,start = 37.dp,end = 37.dp,)
                                .fillMaxWidth()
                        ){
                            Text("10мин",
                                color = Color(0xFF4B4B4B),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .weight(1f)
                            )
                            Text("25мин",
                                color = Color(0xFF4B4B4B),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(end = 79.dp,)
                            )
                            Text("2",
                                color = Color(0xFF4B4B4B),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(end = 84.dp,)
                            )
                            Text("4",
                                color = Color(0xFF4B4B4B),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(vertical = 1.dp,)
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(bottom = 21.dp,start = 28.dp,end = 28.dp,)
                                .fillMaxWidth()
                        ){
                            Text("подготовка",
                                color = Color(0xFF4B4B4B),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .weight(1f)
                            )
                            Text("готовка",
                                color = Color(0xFF4B4B4B),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(end = 54.dp,)
                            )
                            Text("сложность",
                                color = Color(0xFF4B4B4B),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(end = 38.dp,)
                            )
                            Text("порции",
                                color = Color(0xFF4B4B4B),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Text("Ингредиенты",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 29.dp,)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 4.dp,start = 4.dp,end = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(vertical = 10.dp,horizontal = 29.dp,)
                    ){
                        Text("Чоризо — 4 шт ",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(3.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.buy), //блюдо
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 5.dp,)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 4.dp,start = 4.dp,end = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(vertical = 9.dp,horizontal = 29.dp,)
                    ){
                        Text("Оливкое масло — 4 ст. л. ",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(3.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.buy), //блюдо
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 5.dp,)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 4.dp,start = 4.dp,end = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(vertical = 9.dp,horizontal = 30.dp,)
                    ){
                        Text("Красный лук — 4 шт.",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(3.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.buy), //блюдо
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 5.dp,)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 4.dp,start = 4.dp,end = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(vertical = 9.dp,horizontal = 29.dp,)
                    ){
                        Text("Чеснок — 4 зубчик",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(3.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.buy), //блюдо
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 5.dp,)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 4.dp,start = 4.dp,end = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(vertical = 8.dp,horizontal = 29.dp,)
                    ){
                        Text("Белое вино (сухое) — 400 мл",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(3.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.buy), //блюдо
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 5.dp,)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 4.dp,start = 4.dp,end = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(vertical = 9.dp,horizontal = 29.dp,)
                    ){
                        Text("Томатная паста — 8 ст. л.",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(3.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.buy), //блюдо
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 5.dp,)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 4.dp,start = 4.dp,end = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(vertical = 9.dp,horizontal = 29.dp,)
                    ){
                        Text("Орегано — 4 ст. л.",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(3.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.buy), //блюдо
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 5.dp,)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 4.dp,start = 4.dp,end = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(vertical = 9.dp,horizontal = 29.dp,)
                    ){
                        Text("Базилик — 2 пучка",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(3.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.buy), //блюдо
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 5.dp,)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 4.dp,start = 4.dp,end = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(vertical = 9.dp,horizontal = 29.dp,)
                    ){
                        Text("Сливки — 800 мл",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(3.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.buy), //блюдо
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 5.dp,)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 4.dp,start = 4.dp,end = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(vertical = 9.dp,horizontal = 30.dp,)
                    ){
                        Text("Вода от варки пасты — 8 половника",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(3.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.buy), //блюдо
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 5.dp,)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 4.dp,start = 4.dp,end = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(vertical = 8.dp,horizontal = 30.dp,)
                    ){
                        Text("Паста (пенне) — 1600 г",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(3.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.buy), //блюдо
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 5.dp,)
                                    .width(20.dp)
                                    .height(20.dp)
                            )

                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 4.dp,start = 4.dp,end = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(vertical = 8.dp,horizontal = 30.dp,)
                    ){
                        Text("Пармезан (тертый) — 120 г",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(3.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.buy), //блюдо
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 5.dp,)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 4.dp,)
                            .clip(shape = RoundedCornerShape(18.dp))
                            .fillMaxWidth()
                            .background(
                                color = Color(0xFFFFFFFF),
                                shape = RoundedCornerShape(18.dp)
                            )
                            .padding(vertical = 9.dp,horizontal = 29.dp,)
                    ){
                        Text("Страчателла — 600 г",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .weight(1f)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(3.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.buy), //блюдо
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(bottom = 5.dp,)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
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
                            .padding(top = 22.dp,bottom = 38.dp,)
                    ){
                        Text("Инструкция",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(bottom = 14.dp,start = 29.dp,)
                        )
                        Text("Тут краткое описание",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(bottom = 13.dp,start = 29.dp,)
                        )
                        Text("Способ приготовления",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(bottom = 14.dp,start = 29.dp,)
                        )
                        Text("Тут способ приготовления",
                            color = Color(0xFF4B4B4B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .padding(start = 29.dp,)
                        )
                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFF5F5F5),
                    )
                    .padding(vertical = 10.dp,)
            ){
                Column(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))
                        .width(108.dp)
                        .height(4.dp)
                        .background(
                            color = Color(0xFF1D1B20),
                            shape = RoundedCornerShape(12.dp)
                        )
                ){
                }
            }
        }
    }
}