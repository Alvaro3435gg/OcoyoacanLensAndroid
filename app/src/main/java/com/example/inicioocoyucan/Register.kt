package com.example.inicioocoyucan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.inicioocoyucan.ui.theme.InicioOcoyucanTheme

@Composable
fun RegistrationScreen(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFF3C5))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ocoyulogo),
                contentDescription = "logo",
                modifier = modifier
                    .height(100.dp)
                    .width(100.dp)
            )

            Text(
                text = "OCOYUCAN LENS",
                style = TextStyle(fontSize = 24.sp, color = Color(0xFF608560))
            )

            Spacer(modifier = Modifier.height(20.dp))

            RegistrationField(hint = "Nombre completo")
            RegistrationField(hint = "E-mail", keyboardType = KeyboardType.Email)
            RegistrationField(hint = "Crear usuario")
            RegistrationField(hint = "Crear contraseña", keyboardType = KeyboardType.Password)

            Text(
                text = "*La contraseña debe tener al menos 8 caracteres, una letra mayúscula, una minúscula, un número y un símbolo",
                style = TextStyle(fontSize = 10.sp, color = Color.Gray),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Button(
                onClick = {navController.navigate("inicio")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF608560))
            ) {
                Text(text = "Registrarse", color = Color.White)
            }
        }
    }
}

@Composable
fun RegistrationField(hint: String, keyboardType: KeyboardType = KeyboardType.Text) {
    val inputText = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
            .background(Color.White, shape = MaterialTheme.shapes.small)
            .padding(16.dp)
    ) {
        BasicTextField(
            value = inputText.value,
            onValueChange = { inputText.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
            modifier = Modifier.fillMaxWidth()
        )
        if (inputText.value.isEmpty()) {
            Text(
                text = hint,
                style = TextStyle(fontSize = 16.sp, color = Color.Gray)
            )
        }
    }
}

@Preview
@Composable
private fun RegistrationScreenPreview() {
    InicioOcoyucanTheme {
        RegistrationScreen(navController = rememberNavController())
    }
}