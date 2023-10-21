package tn.mpdam1.guessnumber

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.HistoricalChange
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HistoriqueItem(item : String){
    Row (
modifier = Modifier
    .background(Color.DarkGray)
    .fillMaxWidth()
    .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

    Text(
        text = "${item}",
        color= Color.Black
    )
    }
}
@Preview(showBackground = true)
@Composable
fun prev(){
    HistoriqueItem("Hello")
}