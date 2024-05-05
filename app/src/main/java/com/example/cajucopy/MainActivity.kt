package com.example.cajucopy

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cajucopy.data.BenefitsType
import com.example.cajucopy.data.BottomNavigationItem
import com.example.cajucopy.ui.BenefitsListItem
import com.example.cajucopy.ui.BenefitsOrderItem
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
                    AllComponentsScaffold()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun AllComponentsScaffold() {
    val title1 = "REFEIÇÃO"
    val title2 = "PREMIAÇÃO"
    val title3 = "ALIMENTAÇÃO"
    val scroll = rememberScrollState()
    Scaffold(
        topBar = { TopBarComponent() },
        bottomBar = { SetNavigationBar() }) {
        Column(modifier = Modifier.padding(it)) {
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
                    color = BenefitsType.SNACK.color,
                    icon = BenefitsType.SNACK.icon,
                    title = title1
                )
                BenefitsListItem(
                    color = BenefitsType.FEEDING.color,
                    icon = BenefitsType.FEEDING.icon,
                    title = title3
                )
                BenefitsOrderItem(icon = BenefitsType.ORDER.icon)
            }
            Spacer(modifier = Modifier.padding(12.dp))
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
                title = "SALDO LIVRE",
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
}

@Composable
fun SetNavigationBar() {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    val items = listOf(
        BottomNavigationItem(
            title = "Benefícios",
            selectedIcon = painterResource(id = R.drawable.baseline_home_filled_24)
        ),
        BottomNavigationItem(
            title = "Feirinha",
            selectedIcon = painterResource(id = R.drawable.baseline_shopping_bag_24)
        ), BottomNavigationItem(
            title = "Cartões",
            selectedIcon = painterResource(id = R.drawable.baseline_credit_card_24)
        )
    )
    NavigationBar {
        items.forEachIndexed { index, bottomNavigationItem ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                label = { Text(text = bottomNavigationItem.title) },
                onClick = { selectedItemIndex = index },
                icon = {
                    Icon(
                        painter = bottomNavigationItem.selectedIcon,
                        contentDescription = ""
                    )
                })
        }
    }
}

@Preview
@Composable
private fun BottomNavigationPreview() {
    SetNavigationBar()
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
                color = BenefitsType.SNACK.color,
                icon = BenefitsType.SNACK.icon,
                title = title1
            )
            BenefitsListItem(
                color = BenefitsType.FEEDING.color,
                icon = BenefitsType.FEEDING.icon,
                title = title3
            )
            BenefitsOrderItem(icon = BenefitsType.ORDER.icon)
        }
        Spacer(modifier = Modifier.padding(12.dp))
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
            title = "SALDO LIVRE",
            value = "0,00"
        )
        OtherBalanceComponent(
            color = BenefitsType.OTHER_BENEFITS.color,
            icon = BenefitsType.OTHER_BENEFITS.icon,
            title = title2,
            value = "0,00"
        )
        SetNavigationBar()
    }
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

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
private fun CajuScaffoldPreview() {
    CajuScaffold()
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
