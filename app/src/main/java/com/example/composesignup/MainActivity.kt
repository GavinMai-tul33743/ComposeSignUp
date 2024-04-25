package com.example.composesignup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composesignup.ui.theme.ComposeSignUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSignUpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpForm("Android")
                }
            }
        }
    }
}

@Composable
fun SignUpForm(name: String, modifier: Modifier = Modifier) {

    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        val userName = rememberSaveable{(mutableStateOf(""))}
        val email = rememberSaveable{(mutableStateOf(""))}
        val age = rememberSaveable{(mutableStateOf(""))}

        Text(
            text = "Sign Up Form",
            modifier = modifier,
            fontSize = 30.sp
        )

        TextField(value = userName.value,
            onValueChange = {
                userName.value = it
            },
            label = {
                Text(text = "Enter Name")
            }
        )

        TextField(value = age.value,
            onValueChange = {
                age.value = it
            },
            label = {
                Text(text = "Enter Age")
            },
            keyboardOptions =
        )

        TextField(value = email.value,
            onValueChange = {
                email.value = it
            },
            label = {
                Text(text = "Enter Email")
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeSignUpTheme {
        SignUpForm("Android")
    }
}