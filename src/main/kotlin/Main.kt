import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.window.*
import data.ApiService
import data.models.Country
import ui.components.MainScreen


@OptIn(ExperimentalMaterial3Api::class)
fun main() = application {
    var countries by remember { mutableStateOf<List<Country>>(emptyList()) }

    LaunchedEffect(Unit) {
        countries = ApiService.getEuropeanCountries()
    }

    Window(onCloseRequest = ::exitApplication, title = "European Countries") {
        MaterialTheme {
            MainScreen(allCountries = countries)
        }
    }
}
