package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
//import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ImageBitmap
import data.models.Country
import ui.utils.loadNetworkImage

@Composable
fun MainContent(countries: List<Country>, onCountrySelected: (Country) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Adaptive(150.dp), modifier = Modifier.fillMaxSize()) {
        items(countries) { country ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onCountrySelected(country) }
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }

                    LaunchedEffect(country.flags.png) {
                        imageBitmap = loadNetworkImage(country.flags.png)
                    }

                    imageBitmap?.let {
                        Image(
                            bitmap = it,
                            contentDescription = "Flag",
                            modifier = Modifier
                                .height(80.dp)
                                .fillMaxWidth()
                        )
                    }

                    Text(
                        text = country.name.common,
                        style = MaterialTheme.typography.h1
                    )
                    Text(
                        text = country.capital?.firstOrNull() ?: "No capital"
                    )
                }
            }
        }
    }
}
