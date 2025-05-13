package ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SidePanel(onRefresh: () -> Unit, onSearch: (String) -> Unit) {
    var searchText by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("European Countries", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
                onSearch(it)
            },
            label = { Text("Search") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = onRefresh,
            interactionSource = remember { MutableInteractionSource() } // Явно вказуємо interactionSource
        ) {
            Text("Show All")
        }

    }
}
