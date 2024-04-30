package com.example.cajucopy.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cajucopy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent() {
    TopAppBar(
        modifier = Modifier.padding(12.dp),
        title = { Text(text = "Oi, Rafel") },
        navigationIcon = {
            Icon(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .background(Color.Gray),
                painter = painterResource(id = R.drawable.baseline_person_outline_24),
                contentDescription = ""
            )
        },
        actions = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_visibility_24),
                contentDescription = ""
            )
        }
    )
}