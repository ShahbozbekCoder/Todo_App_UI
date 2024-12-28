package com.shahbozbek.todoappui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListItem() {
    val isChecked = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 16.dp)
            .height(70.dp)
            .border(1.dp, Color(0xFFD6D6D6), RoundedCornerShape(20.dp))
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFFDFBD43),
                uncheckedColor = Color.Gray
            )
        )
        Spacer(modifier = Modifier.width(4.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "8:00 AM", color = if (
                    isSystemInDarkTheme()
                ) {
                    Color.White
                } else {
                    Color(0xFFD6D6D6)
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Go to mosque",
                textDecoration = if (isChecked.value) {
                    TextDecoration.LineThrough
                } else {
                    TextDecoration.None
                },
                color = if (
                    isSystemInDarkTheme()
                ) {
                    Color.White
                } else {
                    Color(0xFFD6D6D6)
                }
            )
        }
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.End
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(R.drawable.edit_note),
                    contentDescription = "Delete",
                    tint = Color(0xFFDFBD43)
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(R.drawable.delete),
                    contentDescription = "Delete",
                    tint = Color(0xFFDFBD43)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    ListItem()
}