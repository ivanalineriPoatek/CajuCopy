package com.example.cajucopy

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cajucopy.ui.theme.CajuCopyTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CajuCopyTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    CardContent()
                }
            }
        }
    }
}

@Composable
private fun CardContent() {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {

            val style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Row {
                Text(text = "Teste")
            }
            if (expanded) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total em benefícios",
                        style = style
                    )
                    Text(
                        text = "R$ 0,48",
                        style = style
                    )
                }
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = if (expanded) {
                    ""
                } else {
                    ""
                }
            )
        }
    }
}


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun OtherBenefitsItem() {
    Row(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFE28787)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(contentAlignment = Alignment.CenterStart) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_star_border_24),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(40.dp)
            )
            Text(
                text = "Premiação",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(start = 60.dp)
            )
            Row(
                modifier = Modifier.align(Alignment.CenterEnd),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "R$",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    ),
                )
                Text(
                    text = "0,00", style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BenefitsListItem() {
    val padding = 24.dp
    Box(
        modifier = Modifier
            .height(180.dp)
            .width(120.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFE28787)),
        contentAlignment = Alignment.Center

    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_restaurant_24),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 12.dp, start = padding)
        )
        PriceComponentColumn(
            Modifier
                .align(Alignment.CenterStart)
                .padding(start = padding),
            value = "0,00"
        )
        Text(
            text = "Refeição",
            Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 12.dp, start = padding)
        )
    }
}

@Composable
fun PriceComponentColumn(modifier: Modifier = Modifier, value: String) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "R$",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.align(Alignment.Start)
        )
        Text(
            text = value, style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BenefitsPreview() {
    val padding = 24.dp
    Box(
        modifier = Modifier
            .height(180.dp)
            .width(120.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFE28787)),
        contentAlignment = Alignment.Center

    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_restaurant_24),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 12.dp, start = padding)
        )
        PriceComponentColumn(
            Modifier
                .align(Alignment.CenterStart)
                .padding(start = padding), value = "0,00"
        )
        Text(
            text = "Refeição",
            Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 12.dp, start = padding)
        )
    }
}

@Preview
@Composable
private fun BenefitsRowPreview() {
    Row(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF323232)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(contentAlignment = Alignment.CenterStart) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_star_border_24),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(40.dp),
                tint = Color.White
            )
            Text(
                text = "PREMIAÇÃO",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(start = 60.dp),
                color = Color.White
            )
            PriceRow()
        }
    }
}

@Composable
fun PriceRow() {
    Row(
        modifier = Modifier
            .padding(start = 300.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "R$",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            ),
            color = Color.White
        )
        Text(
            text = "0,00", style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun TopBarPreview() {

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

@Preview(showBackground = true)
@Composable
private fun ExpandInfoAnimation() {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val style = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
    Row(
        modifier = Modifier.padding(12.dp)
    ) {
        Text(
            text = "Total em benefícios",
            style = style
        )

        Text(
            text = "R$ 0,48",
            style = style,
            modifier = Modifier.padding(start = 150.dp)
        )
    }
    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
        ) {

            if (expanded) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    Text(
                        text = "Valor flexível"
                    )
                    Text(
                        text = "R$ 0,09",
                        modifier = Modifier.padding(start = 150.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = if (expanded) {
                    ""
                } else {
                    ""
                }
            )
        }
    }
}

