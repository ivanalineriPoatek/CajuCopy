package com.example.cajucopy.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cajucopy.R



@Preview(showBackground = true)
@Composable
private fun ExpandableComponentPreview() {
    ExpandableComponent()
}

@Composable
fun ExpandableComponent(
    modifier: Modifier = Modifier
) {
    val style = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
    var expanded by rememberSaveable { mutableStateOf(false) }
    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Row {
            Text(
                text = "Total em benefícios",
                modifier
                    .padding(start = 12.dp, end = 12.dp)
                    .weight(1f),
                style = style
            )
            Text(
                modifier = Modifier.padding(end = 8.dp),
                text = "R$0,48",
                style = style,
            )
        }
        if (expanded) {
            Column(modifier = Modifier.padding(top = 8.dp)) {
                Row {
                    Row(modifier = modifier.weight(1f)) {
                        Text(
                            text = "Valor flexível",
                            modifier
                                .padding(start = 12.dp, end = 12.dp)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_info_outline_24),
                            contentDescription = "",
                        )
                    }
                    Text(
                        modifier = Modifier.padding(end = 8.dp),
                        text = "R$0,48",
                        style = style,
                    )
                }
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        text = "Próximo benefício",
                        modifier
                            .padding(start = 12.dp, end = 12.dp)
                            .weight(1f),
                        style = style,
                    )
                    Text(
                        modifier = Modifier.padding(end = 8.dp),
                        text = "Não agendado",
                        style = style,
                    )
                }
            }

        }
        Row(
            modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Box(
                modifier
                    .padding(12.dp)
                    .height(1.dp)
                    .background(Color.Gray)
                    .fillMaxWidth()
                    .weight(5f)
            ) {

            }
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = if (expanded) {
                    ""
                } else {
                    ""
                },
                modifier
                    .weight(1f)
                    .padding(6.dp)
                    .clickable { expanded = !expanded }
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun ExpandableTestPreview() {
    ExpandableComponent()
}