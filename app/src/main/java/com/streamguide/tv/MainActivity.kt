package com.streamguide.tv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Button
import androidx.tv.material3.Text
import androidx.tv.material3.MaterialTheme

private val bg = Color(0xFF101018)
private val accent = Color(0xFF9A72F8)
private val tabs = listOf("Home", "Live TV", "Movies", "Series", "Favorites", "Settings")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { StreamGuideApp() }
    }
}

@Composable
private fun StreamGuideApp() {
    var selected by remember { mutableStateOf("Home") }
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(bg).padding(horizontal = 42.dp, vertical = 28.dp),
            verticalArrangement = Arrangement.spacedBy(26.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                Text("STREAMGUIDE", color = accent, fontSize = 26.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.width(18.dp))
                tabs.forEach { tab ->
                    Button(onClick = { selected = tab }) { Text(tab) }
                }
            }
            if (selected == "Home") {
                Text("Your entertainment, all in one place", fontSize = 32.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text("Live television, movies, and series", fontSize = 18.sp, color = Color.LightGray)
                ContentRow("Continue Watching", listOf("Your recently watched titles", "Resume movies", "Resume episodes"))
                ContentRow("Explore", listOf("Live TV Guide", "Movies", "TV Series", "Favorites"))
            } else {
                Text(selected, fontSize = 34.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text("This section is ready for the next development phase.", fontSize = 19.sp, color = Color.LightGray)
                if (selected == "Settings") Text("Coming next: M3U URL, Xtream Codes and local playlist import.", color = accent)
            }
            Spacer(Modifier.weight(1f))
            Text("StreamGuide • Preview build 0.1 • Use your Shield remote to navigate", color = Color.Gray, fontSize = 14.sp)
        }
    }
}

@Composable
private fun ContentRow(title: String, items: List<String>) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(title, color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 23.sp)
        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(items) { item ->
                Button(onClick = { }) {
                    Box(Modifier.width(175.dp).height(80.dp), contentAlignment = Alignment.Center) {
                        Text(item)
                    }
                }
            }
        }
    }
}
