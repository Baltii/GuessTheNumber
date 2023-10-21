package tn.mpdam1.guessnumber


import android.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun HomeScreen(
    navController: NavController
){
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier=Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "GuessTheNumber",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Button(
                modifier = Modifier.padding(24.dp),
                onClick = { navController.navigate(route = Screens.basic.route) }) {
                Text(text = "Basic Mode")
            }
            Button(
                modifier = Modifier.padding(24.dp),
                onClick = { navController.navigate(route = Screens.advanced.route) }) {
                Text(text = "Advanced Mode")
            }
        }
        }
}