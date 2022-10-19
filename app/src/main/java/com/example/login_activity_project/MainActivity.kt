package com.example.login_activity_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.login_activity_project.ui.theme.Login_activity_projectTheme

class MainActivity : ComponentActivity() {
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login_activity_projectTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginUI()
                }
            }
        }
    }
}

@Composable
fun LoginUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }


        Text(
            text = "Login Here",
            textAlign = TextAlign.Left,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = { Text(text = "Enter Your Name") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "person"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)

        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Enter Your password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "password"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        val context = LocalContext.current
        Button(
            onClick = { logged(email.toString(), password.toString(), context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
                .height(50.dp)
        ) {
            Text(text = "Login", textAlign = TextAlign.Center,fontSize = 20.sp)
        }

    }
}

fun logged(email: String, password: String, context: Context) {

    if ((email == "ganraj") && (password == "1234")) {
        Toast.makeText(context, "Logged In Successfully", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(context, "Logged In failed", Toast.LENGTH_SHORT).show()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Login_activity_projectTheme {
        LoginUI()
    }
}
