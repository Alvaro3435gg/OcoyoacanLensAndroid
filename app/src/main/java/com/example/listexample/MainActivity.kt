package com.example.listexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listexample.data.DataSource
import com.example.listexample.model.Plant
import com.example.listexample.ui.theme.ListexampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListexampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PlantList(plantList = DataSource().loadPlants(),
                    Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun PlantCard(plant: Plant, modifier: Modifier = Modifier){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ){
        Row {
            Image(
                painter = painterResource(id = plant.imageResId),
                contentDescription = stringResource(id = plant.nameResId),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth(0.5f)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
            ){
                Text(
                    text = stringResource(id = plant.nameResId),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = stringResource(id = plant.scNameResId),
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = stringResource(id = plant.descriptionResId),
                    fontSize = 10.sp,
                    lineHeight = 14.sp,
                    modifier = Modifier.padding(8.dp)

                )
                Text(
                    text = stringResource(id = plant.sourceResId),
                    fontSize = 8.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(start = 8.dp)
                )


            }
        }
    }
}

@Composable
fun PlantList(plantList: List<Plant>, modifier: Modifier = Modifier){
    LazyRow {
        items(plantList) { plant ->
            PlantCard(plant = plant)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListexampleTheme {
        PlantList(DataSource().loadPlants())
    }
}