package com.example.composesignup

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
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
        val context = LocalContext.current
        val userName = rememberSaveable{(mutableStateOf(""))}
        val nameError = rememberSaveable{(mutableStateOf(false))}
        val email = rememberSaveable{(mutableStateOf(""))}
        val age = rememberSaveable{(mutableStateOf(""))}

        Text(
            text = "Sign Up Form",
            modifier = modifier,
            fontSize = 30.sp
        )

        TextField(value = userName.value,
            onValueChange = {
                nameError.value=false
                userName.value = it
            },
            label = {
                Text(text = "Enter Name")
            },
            isError = nameError.value
        )

        TextField(value = age.value,
            onValueChange = {
                age.value = it
            },
            label = {
                Text(text = "Enter Age")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(value = email.value,
            onValueChange = {
                email.value = it
            },
            label = {
                Text(text = "Enter Email")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

        )

        Button(onClick = {
            var message = "Success"
            if(userName.value.isEmpty()){
                nameError.value = true
                message = "Retry"
            }
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()


        }) {
            Text(text="save")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeSignUpTheme {
        SignUpForm("Android")
    }
}