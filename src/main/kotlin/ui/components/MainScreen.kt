package ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.models.Country
@Composable
fun MainScreen(allCountries: List<Country>) {
    var filteredCountries by remember { mutableStateOf(allCountries) }

    // автоматичне оновлення при зміні allCountries
    LaunchedEffect(allCountries) {
        filteredCountries = allCountries
    }

    Row(modifier = Modifier.fillMaxSize()) {
        SidePanel(
            onRefresh = {
                filteredCountries = allCountries
            },
            onSearch = { query ->
                filteredCountries = allCountries.filter {
                    it.name.common.contains(query, ignoreCase = true)
                }
            }
        )
        Spacer(modifier = Modifier.width(16.dp))
        MainContent(
            countries = filteredCountries,
            onCountrySelected = { country ->
                // можна показати подробиці
            }
        )
    }
}

