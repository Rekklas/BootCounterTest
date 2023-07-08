package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            val liveData = Dependencies.init(this@MainActivity).bootCounterDao.getBootCounterLiveData()
            liveData.observe(this@MainActivity) { data ->
                val text = when (val size = data.size) {
                    0 -> "No boots detected"
                    1 -> "The boot was detected with the timestamp ${data[0].timestamp}"
                    else -> {
                        val delta = data[size - 1].timestamp - data[size - 2].timestamp
                        "Last boots time delta $delta"
                    }
                }
                setContent { BootCounterText(counterTxt = text) }
            }
        }
    }
}

@Composable
fun BootCounterText(counterTxt: String) {
    Text(
        text = counterTxt
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        BootCounterText("Android")
    }
}