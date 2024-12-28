package com.shahbozbek.todoappui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainUiScreen(
    paddingValues: PaddingValues,
    viewModel: TodoViewModel,
    navController: NavHostController
) {
    val selectedItem = remember {
        mutableStateOf(3)
    }
    var searchQuery by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(if (isSystemInDarkTheme()) Color.Black else Color(0xFFFFFDF4))
    ) {
        fun week(): List<String> {
            val today = LocalDate.now()
            val daysOfWeek = mutableListOf<String>()

            for (i in -3..3) {
                val dayOfWeek = today.plusDays(i.toLong()).dayOfWeek.name
                daysOfWeek.add(dayOfWeek)
            }

            return daysOfWeek
        }

        fun date(): List<String> {
            val today = LocalDate.now()

            val dates = mutableListOf<String>()
            val formatter = DateTimeFormatter.ofPattern("d-MMM")
            for (i in -3..3) {
                val date = today.plusDays(i.toLong()).dayOfMonth.toString()
                dates.add(date)
            }
            return dates
        }
        Column {
            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(100.dp)
                    .padding(start = 24.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Good evening, Ivy",
                Modifier
                    .padding(start = 16.dp)
                    .background(if (isSystemInDarkTheme()) Color.Transparent else Color(0xFFF5F2E8)),
                fontSize = 18.sp,
                color = if (isSystemInDarkTheme()) Color.White else Color(0xFF444444)
            )
            Spacer(modifier = Modifier.size(16.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(80.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val weeks = week().toMutableList()
                val dates = date().toMutableList()
                items(dates.size) { index ->
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(if (selectedItem.value == index) 50.dp else 35.dp)
                                .clip(shape = CircleShape)
                                .background(
                                    if (selectedItem.value == index) Color(0xFFDFBD43) else Color(
                                        0xFF4D4117
                                    )
                                )
                                .clickable {
                                    selectedItem.value = index
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = dates[index],
                                color = Color.White,
                                fontSize = 16.sp,
                            )
                        }
                        Spacer(modifier = Modifier.size(8.dp))
                        Text(
                            text = weeks[index].substring(0..2),
                            color = when {
                                isSystemInDarkTheme() && selectedItem.value == index -> Color(
                                    0xFFDFBD43
                                )

                                isSystemInDarkTheme() && selectedItem.value != index -> Color.White
                                !isSystemInDarkTheme() && selectedItem.value != index -> Color(
                                    0xFF4D4117
                                )

                                !isSystemInDarkTheme() && selectedItem.value == index -> Color(
                                    0xFFDFBD43
                                )

                                else -> Color(0xFF4D4117)
                            },
                            fontSize = 12.sp
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            TextField(
                value = searchQuery,
                onValueChange = {
                    searchQuery = it
                },
                shape = RoundedCornerShape(30.dp),
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(30.dp)
                    ),
                placeholder = { Text(text = "Search") },
                leadingIcon = {
                    Image(
                        painter = painterResource(R.drawable.search),
                        contentDescription = "Search",
                        modifier = Modifier.size(20.dp)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "Today's tasks", fontWeight = FontWeight.Bold, fontSize = 22.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            LazyColumn{
                items(10) {
                    ListItem()
                }
            }
        }

    }
}
