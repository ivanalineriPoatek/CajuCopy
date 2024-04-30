package com.example.cajucopy

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cajucopy.data.BenefitsType
import com.example.cajucopy.ui.BenefitsListItem
import com.example.cajucopy.ui.ExpandableComponent
import com.example.cajucopy.ui.OtherBalanceComponent
import com.example.cajucopy.ui.PriceRowComponent
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
                    CajuScaffold()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun CajuScaffoldPreview() {
    CajuScaffold()
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun CajuScaffold() {
    val title1 = "REFEIÇÃO"
    val title2 = "PREMIAÇÃO"
    val title3 = "ALIMENTAÇÃO"
    val scroll = rememberScrollState()
    Column(modifier = Modifier.padding(12.dp)) {
        TopBarComponent()
        Text(
            text = "BENEFÍCIOS",
            modifier = Modifier.padding(12.dp),
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier
                .horizontalScroll(scroll)
                .padding(start = 8.dp)
        ) {
            BenefitsListItem(
                modifier = Modifier.padding(end = 8.dp),
                color = BenefitsType.FEEDING.color,
                icon = BenefitsType.FEEDING.icon,
                title = title3
            )
            BenefitsListItem(
                color = BenefitsType.SNACK.color,
                icon = BenefitsType.SNACK.icon,
                title = title1
            )
        }
        ExpandableComponent()
        Text(
            text = "OUTROS SALDOS",
            modifier = Modifier.padding(12.dp),
            fontWeight = FontWeight.Bold
        )
        OtherBalanceComponent(
            modifier = Modifier.padding(bottom = 8.dp),
            color = BenefitsType.TOTAL_BALANCE.color,
            icon = BenefitsType.TOTAL_BALANCE.icon,
            title = BenefitsType.TOTAL_BALANCE.name,
            value = "0,00"
        )
        OtherBalanceComponent(
            color = BenefitsType.OTHER_BENEFITS.color,
            icon = BenefitsType.OTHER_BENEFITS.icon,
            title = title2,
            value = "0,00"
        )
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
fun BenefitsPreview() {
    val color = BenefitsType.SNACK.color
    val icon = BenefitsType.SNACK.icon
    val title = "REFEIÇÃO"
    BenefitsListItem(color = color, icon = icon, title)
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

