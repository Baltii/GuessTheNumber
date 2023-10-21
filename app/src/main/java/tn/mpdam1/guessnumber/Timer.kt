import android.os.CountDownTimer
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimerScreen() {
    var timeRemaining by remember { mutableStateOf(20) }
    var isRunning by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (timeRemaining < 1){
            Text(text = "TIME IS UP!!", fontSize = 50.sp, color = Color.Red)
        }
        Text(text = "Timer: $timeRemaining seconds", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        if (!isRunning) {
            Button(
                onClick = {
                    isRunning = true
                    startTimer(timeRemaining){timer -> timeRemaining = timer}
                }
            ) {
                Text("Start")
            }
        } else {
            Button(
                onClick = {
                    isRunning = false
                    timeRemaining = 20
                }
            ) {
                Text("Reset")
            }
        }
    }
}

fun startTimer(initialTime: Int, setTimer: (Int) -> Unit) {
    object : CountDownTimer((initialTime * 1000).toLong(), 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val secondsRemaining = (millisUntilFinished / 1000).toInt()
            setTimer(secondsRemaining)
        }

        override fun onFinish() {
            setTimer(0)
        }
    }.start()
}


