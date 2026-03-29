package com.ankita.nutriscan.feature.scanner

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ScannerScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Barcode Scanner", fontWeight = FontWeight.Bold) })
        }
    ) { padding ->
        Box(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text("Scanner — coming in Week 7", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
