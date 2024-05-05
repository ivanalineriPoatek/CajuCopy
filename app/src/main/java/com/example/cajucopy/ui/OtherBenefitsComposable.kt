package com.example.cajucopy.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.cajucopy.data.BenefitsType

@Composable
fun OtherBalanceComponent(
    color: Color,
    @DrawableRes icon: Int,
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .background(color),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "",
                modifier = modifier
                    .padding(start = 8.dp)
                    .size(40.dp),
                tint = Color.White
            )
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = modifier
                    .padding(start = 8.dp),
                color = Color.White
            )
        }
        PriceRowComponent(value)
    }
}

@Preview(showBackground = true)
@Composable
private fun BenefitsRowPreview() {
    val color = BenefitsType.OTHER_BENEFITS.color
    val icon = BenefitsType.OTHER_BENEFITS.icon
    val title = "PREMIAÇÃO"
    val value = "0,00"
    OtherBalanceComponent(color = color, icon = icon, title = title, value = value)
}