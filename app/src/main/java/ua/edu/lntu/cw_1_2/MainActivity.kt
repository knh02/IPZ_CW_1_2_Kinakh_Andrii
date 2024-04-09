package ua.edu.lntu.cw_1_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.lntu.cw_1_2.ui.theme.IPZ_CW_1_2_Кінах_АндрійTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CW_1_2_Кінах_АндрійTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignIn()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn( modifier: Modifier = Modifier) {
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Control Work")
                },
                modifier = modifier,
            )
        }
    )
    { innerPadding -> Modifier.padding(25.dp)
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            TextField(
                value = email,
                onValueChange = { newEmail ->
                    email = newEmail
                },
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth(),
                label = {
                    Text("Enter email")
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
            )
            TextField(
                value = password,
                onValueChange = { newPassword ->
                    password = newPassword
                },
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth(),
                label = {
                    Text("Enter password")
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
            )

            Button(
                onClick = {
                    val result = when {
                        email.isEmpty() -> {
                            // Вивести помилку для поля email та повідомлення про помилку авторизації
                            println("Помилка для поля email: Поле не може бути порожнім")
                            "Помилка авторизації"
                        }
                        password.isEmpty() -> {
                            // Вивести помилку для поля password та повідомлення про помилку авторизації
                            println("Помилка для поля password: Поле не може бути порожнім")
                            "Помилка авторизації"
                        }
                        else -> {
                            // Успішна авторизація
                            "Успішна авторизація"
                        }
                    }
                    // Вивести результат авторизації
                    println(result)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sign In")
            }
        }

    };

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IPZ_CW_1_2_Кінах_АндрійTheme {
        SignIn();
    }
}