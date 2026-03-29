package com.ankita.nutriscan.feature.search

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun SearchScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Search", fontWeight = FontWeight.Bold) })
        }
    ) { padding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text("Search — coming in Week 3", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
