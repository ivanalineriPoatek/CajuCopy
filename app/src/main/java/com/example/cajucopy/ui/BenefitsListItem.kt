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
import androidx.compose.ui.unit.dp
import com.example.cajucopy.R

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BenefitsListItem(
    color: Color,
    @DrawableRes icon: Int,
    title: String
) {
    val padding = 24.dp
    Box(
        modifier = Modifier
            .height(180.dp)
            .width(120.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color = color),
        contentAlignment = Alignment.Center

    ) {
        Icon(
            painter = painterResource(id = icon),
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
            text = title,
            Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 12.dp, start = padding)
        )
    }
}