package com.example.inicioocoyucan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.inicioocoyucan.ui.theme.InicioOcoyucanTheme

@Composable
fun Rutas(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(83, 135, 87))
    ) {
        BottomNavigationBar(navController = navController)
        Text(text = "Pantalla de rutas")
    }
}

@Preview(showBackground = true)
@Composable
fun RutasPreview() {
    InicioOcoyucanTheme {
        Escanear(navController = rememberNavController())
    }
}