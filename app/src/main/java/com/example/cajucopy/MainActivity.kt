package com.example.cajucopy

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.cajucopy.data.BenefitsType
import com.example.cajucopy.ui.BenefitsListItem
import com.example.cajucopy.ui.ExpandableComponent
import com.example.cajucopy.ui.OtherBalanceComponent
import com.example.cajucopy.ui.TopBarComponent
import com.example.cajucopy.ui.theme.CajuCopyTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CajuCopyTheme {
                // A surface container using the 'background' color from the theme
                Surface {

                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
fun BenefitsPreview() {
    val color = BenefitsType.SNACK.color
    val icon = BenefitsType.SNACK.icon
    val title = "REFEIÇÃO"
    BenefitsListItem(color = color, icon = icon,title)
}

@Preview
@Composable
private fun BenefitsRowPreview() {
    val color = BenefitsType.OTHER_BENEFITS.color
    val icon = BenefitsType.OTHER_BENEFITS.icon
    val title = "PREMIAÇÃO"
    val value = "0,00"
    OtherBalanceComponent(color = color, icon = icon, title = title, value = value)
}


@Preview
@Composable
private fun TopBarPreview() {
    TopBarComponent()
}

@Preview(showBackground = true)
@Composable
private fun ExpandInfoAnimation() {
    ExpandableComponent()
}

