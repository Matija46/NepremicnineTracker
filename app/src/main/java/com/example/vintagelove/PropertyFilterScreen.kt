package com.example.vintagelove

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PropertyFilterScreen() {
    var location by remember { mutableStateOf("") }
    var minPrice by remember { mutableStateOf(0f) }
    var maxPrice by remember { mutableStateOf(1000f) }
    var selectedPropertyType by remember { mutableStateOf("Any") }
    var bedrooms by remember { mutableStateOf(1) }
    var bathrooms by remember { mutableStateOf(1) }

    val propertyTypes = listOf("Vse", "Stanovanje", "Hiša", "Vikend")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Filtriraj Nepremičnine",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Location
        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Lokacija") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Price Range
        Text(text = "Cena: ${minPrice.toInt()} - ${maxPrice.toInt()}")

        Spacer(modifier = Modifier.height(16.dp))

        // Property Type
        Text(text = "Nepremičnina")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            propertyTypes.forEach { type ->
                Chip(
                    isSelected = type == selectedPropertyType,
                    onClick = { selectedPropertyType = type },
                    label = type
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Bedrooms
        Text(text = "Število spalnic: $bedrooms")
        Slider(
            value = bedrooms.toFloat(),
            onValueChange = { bedrooms = it.toInt() },
            valueRange = 1f..10f,
            steps = 9
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Bathrooms
        Text(text = "Število kopalnic: $bathrooms")
        Slider(
            value = bathrooms.toFloat(),
            onValueChange = { bathrooms = it.toInt() },
            valueRange = 1f..10f,
            steps = 9
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Apply Filters Button
        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Dodaj opomnik")
        }
    }
}

@Composable
fun Chip(isSelected: Boolean, onClick: () -> Unit, label: String) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .toggleable(
                value = isSelected,
                onValueChange = { onClick() }
            ),
        color = if (isSelected) MaterialTheme.colorScheme.primary else Color.LightGray,
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = label,
            color = if (isSelected) Color.White else Color.Black,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewPropertyFilterScreen() {
    MaterialTheme {
        PropertyFilterScreen()
    }
}
