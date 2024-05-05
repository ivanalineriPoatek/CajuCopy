package com.example.cajucopy.ui

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cajucopy.data.BenefitsType

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BenefitsListItem(
    color: Color,
    @DrawableRes icon: Int,
    title: String,
    modifier: Modifier = Modifier
) {
    val padding = 30.dp
    Box(
        modifier = modifier
            .height(180.dp)
            .width(120.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color = color),
        contentAlignment = Alignment.Center

    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "",
            modifier = modifier
                .align(Alignment.TopStart)
                .padding(top = 12.dp, start = padding)
        )
        PriceComponentColumn(
            modifier
                .align(Alignment.CenterStart)
                .padding(start = padding),
            value = "0,00"
        )
        Text(
            text = title,
            modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp),
            fontSize = 12.sp,
        )
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
fun BenefitsPreview() {
    val color = BenefitsType.FEEDING.color
    val icon = BenefitsType.FEEDING.icon
    val title = "REFEIÇÃO"
    BenefitsListItem(color = color, icon = icon, title)
}