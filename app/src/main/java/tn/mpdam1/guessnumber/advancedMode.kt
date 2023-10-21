package tn.mpdam1.guessnumber



import TimerScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue



@Composable
fun AdvancedMode(){
    var target by remember { mutableStateOf((1..100).random()) }
    var gues by remember { mutableStateOf("0") }
    var msg by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimerScreen()

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = gues,
            onValueChange = { gues = it },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done, keyboardType = KeyboardType.Number),
            keyboardActions = KeyboardActions(
                onDone = {
                    checkGuess2(gues.toIntOrNull(), target){ newMessage ->
                        msg = newMessage;

                    }
                    if (gues == target.toString()){
                        gues = target.toString()
                    }else{
                        gues = ""
                    }

                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(20.dp)),
            textStyle = TextStyle(fontSize = 64.sp, textAlign = TextAlign.Center),

            )
        Spacer(modifier = Modifier.height(24.dp))

        Text("Advanced Mode", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Text("You have 20 seconds to guess the number", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Text("$msg", fontSize = 20.sp)

    }
}

fun checkGuess2(userGuess: Int?, targetNumber: Int, setMessage: (String) -> Unit) {
    if (userGuess == null) {
        setMessage("Invalid input. Please enter a number.")
    } else {
        if (userGuess < targetNumber) {
            setMessage("Higher! Try again.")
        } else if (userGuess > targetNumber) {
            setMessage("Lower! Try again.")
        } else {
            setMessage("Congratulations! You guessed the number! $targetNumber")
        }
    }
}
