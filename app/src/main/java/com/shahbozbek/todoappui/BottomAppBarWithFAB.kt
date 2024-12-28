package com.shahbozbek.todoappui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomAppBarWithFAB(
    todoViewModel: TodoViewModel,
    navController: NavHostController
) {
    val content = remember {
        mutableStateOf("Home Screen")
    }
    val selectedItem = remember {
        mutableStateOf("home")
    }
    Scaffold(
        modifier = Modifier.padding(top = 24.dp),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("add")
                },
                shape = CircleShape,
                backgroundColor = Color(0xFFDFBD43)
            )
            {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "add",
                    Modifier.size(36.dp),
                    Color.White
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        content = {
            MainUiScreen(
                paddingValues = it,
                viewModel = todoViewModel,
                navController = navController
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .clip(RoundedCornerShape(50)),
                cutoutShape = RoundedCornerShape(50),
                backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color(0xFFEDEAEA),
                content = {
                    BottomNavigation(backgroundColor = Color(0xFFEDEAEA)) {
                        BottomNavigationItem(
                            selected = selectedItem.value == "home",
                            onClick = {
                                content.value = "Home Screen"
                                selectedItem.value = "home"
                            },
                            icon = {
                                Icon(
                                    Icons.Filled.Home, contentDescription = "home",
                                    tint = if (selectedItem.value == "home") Color.Black else Color(
                                        0xFF444444
                                    )
                                )
                            },
                            alwaysShowLabel = false,
                            selectedContentColor = Color(0xFFDFBD43),
                        )
                        BottomNavigationItem(
                            selected = selectedItem.value == "calendar",
                            onClick = {
                                content.value = "Calendar Screen"
                                selectedItem.value = "calendar"
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(R.drawable.calendar_today),
                                    contentDescription = "calendar",
                                    tint = if (selectedItem.value == "calendar") Color.Black else Color(
                                        0xFF444444
                                    )
                                )
                            },
                            alwaysShowLabel = false,
                            selectedContentColor = Color(0xFFDFBD43),
                        )
                        BottomNavigationItem(
                            selected = selectedItem.value == "notifications",
                            onClick = {
                                selectedItem.value = "notifications"
                                content.value = "Notifications Screen"
                            },
                            icon = {
                                Icon(
                                    Icons.Filled.Notifications,
                                    contentDescription = "settings",
                                    tint = if (selectedItem.value == "notifications") Color.Black else Color(
                                        0xFF444444
                                    )
                                )
                            },
                            alwaysShowLabel = false,
                            selectedContentColor = Color(0xFFDFBD43),
                        )
                        BottomNavigationItem(
                            selected = selectedItem.value == "apps",
                            onClick = {
                                selectedItem.value = "apps"
                                content.value = "Apps Screen"
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(R.drawable.apps),
                                    contentDescription = "apps",
                                    tint = if (selectedItem.value == "apps") Color.Black else Color(
                                        0xFF444444
                                    )
                                )
                            },
                            alwaysShowLabel = false,
                            selectedContentColor = Color(0xFFDFBD43),
                        )
                    }
                },
            )
        }
    )

}
