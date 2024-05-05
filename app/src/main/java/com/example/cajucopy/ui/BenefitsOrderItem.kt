package com.example.cajucopy.ui

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BenefitsOrderItem(
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(180.dp)
            .padding(start = 8.dp)
            .width(120.dp)
            .border(BorderStroke(1.dp, Color.Blue), RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.Center

    ) {
        Box(contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .size(50.dp)
                .border(BorderStroke(1.dp, Color.Blue), RoundedCornerShape(50.dp))

        ) {
            Icon(
                tint = Color.Blue,
                modifier = Modifier
                    .padding(start = 13.dp),
                painter = painterResource(id = icon),
                contentDescription = ""
            )
        }
    }
}
