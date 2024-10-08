package com.example.inicioocoyucan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inicioocoyucan.ui.theme.InicioOcoyucanTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.inicioocoyucan.data.DataSourcePlant
import com.example.inicioocoyucan.model.Plant

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
            Lista(DataSourcePlant().loadPlants())
        }
        UserSection()
        BottomNavigationBar(navController)
    }
}

@Composable
fun PlantCard(plant: Plant, modifier: Modifier = Modifier){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            // Imagen de la planta
            Image(
                painter = painterResource(id = plant.imageResId),
                contentDescription = stringResource(id = plant.nameResId),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
            )

            Text(
                text = stringResource(id = plant.nameResId),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )

            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = Color(83, 135, 87))) {

                Text(
                    text = "Ver detalles",
                    fontSize = 12.sp,
                    color = Color(234, 244, 202))
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantLibraryDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Todas las plantas") }

    val options = listOf("Todas las plantas", "Mis plantas")

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier.menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        selectedOption = option
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun Lista(plantList: List<Plant>, modifier: Modifier = Modifier){
    Column(
        Modifier
            .fillMaxHeight()
            .padding(bottom = 100.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Biblioteca de flora",
            fontSize = 24.sp,
            color = Color(234, 244, 202),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        PlantLibraryDropdownMenu()

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier.padding(8.dp)
        ) {
            items(plantList.size) { index ->
                PlantCard(plant = plantList[index], modifier = Modifier.padding(8.dp))
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GaleriaPreview() {
    InicioOcoyucanTheme {
        Galeria(navController = rememberNavController())
    }
}