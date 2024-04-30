package com.example.cajucopy.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cajucopy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent() {
    TopAppBar(
        modifier = Modifier.padding(12.dp),
        title = { textBold(name = "Rafael") },
        navigationIcon = {
            SetIconShape()
        },
        actions = {
            Icon(
                modifier = Modifier.padding(end = 12.dp),
                painter = painterResource(id = R.drawable.baseline_visibility_24),
                contentDescription = ""
            )
        }
    )
}

@Composable
fun textBold(name: String): String {
    Row(modifier = Modifier.padding(12.dp)) {
        Text(text = "Oi, ")
        Text(
            text = name,
            fontWeight = FontWeight.Bold
        )
    }
    return name
}

@Composable
fun SetIconShape() {
    Box(contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.Gray)

    ) {
        Icon(
            modifier = Modifier
                .padding(start = 12.dp),
            painter = painterResource(id = R.drawable.baseline_person_outline_24),
            contentDescription = ""
        )
    }

}

@Preview
@Composable
private fun ToolBarComponentPreview() {
    TopBarComponent()

}