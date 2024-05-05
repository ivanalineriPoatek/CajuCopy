package com.example.cajucopy.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.cajucopy.R

enum class BenefitsType(val color: Color, @DrawableRes val icon: Int) {
    FEEDING(Color(0xFFF3B072), R.drawable.baseline_foggy_24),
    SNACK(Color(0xFFF18183),R.drawable.baseline_restaurant_24 ),
    TOTAL_BALANCE(Color(0xFFCE87CB), R.drawable.baseline_credit_card_24),
    OTHER_BENEFITS(Color(0xFF323232), R.drawable.baseline_star_border_24),
    ORDER(Color.White, R.drawable.baseline_dynamic_feed_24)
}