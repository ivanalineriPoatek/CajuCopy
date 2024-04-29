package com.example.cajucopy.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.cajucopy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent() {
    TopAppBar(
        title = { Text(text = "Oi, Rafel") },
        navigationIcon = {
            Icon(
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