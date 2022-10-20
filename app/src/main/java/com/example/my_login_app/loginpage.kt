package com.example.my_login_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.my_login_app.ui.theme.My_login_appTheme

class loginpage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            My_login_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Logged")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "You are Successfully $name! In")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    My_login_appTheme {
        Greeting("Logged")
    }
}