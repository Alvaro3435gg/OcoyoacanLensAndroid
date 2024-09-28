package com.example.inicioocoyucan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inicioocoyucan.ui.theme.InicioOcoyucanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InicioOcoyucanTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "inicio") {
                composable("inicio") { Inicio(navController) }
                composable("galeria") { Galeria(navController) }
            }
            }
        }
    }
}

@Composable
fun Inicio(navController: NavController, modifier: Modifier = Modifier) {
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
            HeaderSection()
            CarruselSection(navController)
            VisionSection()
        }
        UserSection()
        BottomNavigationBar(navController)
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ocoyulogo),
            contentDescription = "Logo Ocoyucan",
            modifier = Modifier.size(80.dp)
        )
    }
}

@Composable
fun UserSection() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_icon),
            contentDescription = "Ícono de usuario",
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )
    }
}

@Composable
fun CarruselSection(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Text(
            text = "Conoce nuestra flora...",
            fontSize = 24.sp,
            color = Color(234, 244, 202),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(200.dp)
                .background(Color(244, 246, 238), shape = RoundedCornerShape(10.dp))
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plant1),
                    contentDescription = "Planta 1",
                    modifier = Modifier.size(80.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.plant2),
                    contentDescription = "Planta 2",
                    modifier = Modifier.size(80.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.plant3),
                    contentDescription = "Planta 3",
                    modifier = Modifier.size(80.dp)
                )
            }

            Button(
                onClick = { navController.navigate("galeria") },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(Color(83, 135, 87))
            ) {
                Text(text = "Ver más", color = Color.White)
            }
        }
    }
}

@Composable
fun VisionSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Visión",
            fontSize = 24.sp,
            color = Color(234, 244, 202),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Nuestra visión es promover la restauración ecológica en México como una alternativa a las prácticas convencionales de reforestación, con el propósito de contribuir a la recuperación de ecosistemas forestales y selvícolas perturbados por la actividad humana. A través de la restauración, buscamos generar áreas rehabilitadas que sirvan como plataformas para el desarrollo sostenible de las comunidades locales, asegurando un proceso activo mediante el aprovechamiento de los recursos biológicos autóctonos.",
            fontSize = 20.sp,
            color = Color(234, 244, 202)
        )
    }
}

@Composable
fun Icono(
    painter: Painter,
    contentDescription: String = "",
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .padding(1.dp)
            .clickable(onClick = onClick), // Envolvemos la columna con un modificador clickable
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(64.dp)
                .fillMaxWidth()
        )
        Text(
            text = text,
            color = Color(201, 220, 176),
            fontSize = 15.sp
        )
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(106, 152, 106))
                .padding(vertical = 25.dp)
                .align(Alignment.BottomCenter)
                .height(90.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icono(painter = painterResource(id = R.drawable.rutas), text = "Rutas")
            Icono(painter = painterResource(id = R.drawable.recompensas), text = "Recompensas")
            Icono(painter = painterResource(id = R.drawable.escanear), text = "Escanear")
            Icono(painter = painterResource(
                id = R.drawable.flora),
                text = "Flora",
                onClick = {navController.navigate("galeria")})
            Icono(painter = painterResource(
                id = R.drawable.inicioselect),
                text = "Inicio",
                onClick = {navController.navigate("inicio")})
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InicioOcoyucanTheme {
        Inicio(navController = rememberNavController())
    }
}