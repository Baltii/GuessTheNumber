package tn.mpdam1.guessnumber

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

@Composable
fun BasicMode(){
        var targetNumber by remember { mutableStateOf((1..100).random()) }
        var guess by remember { mutableStateOf("0") }
        var message by remember { mutableStateOf("") }
        var arrayLogs by remember { mutableStateOf(mutableListOf<String>()) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = guess,
                onValueChange = { guess = it },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done, keyboardType = KeyboardType.Number),
                keyboardActions = KeyboardActions(
                    onDone = {
                        checkGuess(guess.toIntOrNull(), targetNumber){ newMessage ->
                            message = newMessage;
                            arrayLogs.add(guess+' '+message);

                        }

                        guess = ""
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(20.dp)),
                textStyle = TextStyle(fontSize = 64.sp, textAlign = TextAlign.Center),

                )
            Spacer(modifier = Modifier.height(24.dp))

            Text("Basic Mode", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))

            Text("I'm thinking of a number between 1 and 100. Can you guess it?", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))

            TextList(items = arrayLogs)
            }

        }

    fun checkGuess(userGuess: Int?, targetNumber: Int, setMessage: (String) -> Unit) {
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

@Composable
fun TextList(items: List<String>) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        items.forEach { item ->
            Text(text = item, fontSize = 16.sp, modifier = Modifier.padding(8.dp))
        }
    }
}
