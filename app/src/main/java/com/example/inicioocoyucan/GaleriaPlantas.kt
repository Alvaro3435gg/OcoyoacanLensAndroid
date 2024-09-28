package com.example.inicioocoyucan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inicioocoyucan.ui.theme.InicioOcoyucanTheme
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Galeria(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(83, 135, 87))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)
        ) {
            Lista()
        }
        UserSection()
        BottomNavigationBar(navController)
    }
}

@Composable
fun Lista(){
    Text(text = "ACÁ VA LA GALERÍA D PLANTAS JALKSJA")
}

@Preview(showBackground = true)
@Composable
fun GaleriaPreview() {
    InicioOcoyucanTheme {
        Galeria(navController = rememberNavController())
    }
}