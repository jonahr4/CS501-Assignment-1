package com.example.helloandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloandroid.ui.theme.HelloAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloAndroidTheme {
                // You can keep Scaffold if you want; just apply innerPadding
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        fullName = "Jonah Rothman",
                        buEmail = "jonahr@bu.edu",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(fullName: String, buEmail: String, modifier: Modifier = Modifier) {
    var message by remember { mutableStateOf("Welcome to Compose") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = fullName)
        Spacer(Modifier.height(8.dp))
        Text(text = buEmail)
        Spacer(Modifier.height(24.dp))
        Text(text = message)
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            message = if (message.startsWith("Welcome"))
                "Button clicked"
            else
                "Welcome to Compose"
        }) {
            Text("Change Message")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    HelloAndroidTheme {
        Greeting(
            fullName = "Your Name",
            buEmail = "yourlogin@bu.edu",
            modifier = Modifier.fillMaxSize()
        )
    }
}