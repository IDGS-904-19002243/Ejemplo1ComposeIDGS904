package com.example.ejemplo1composeidgs904

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejemplo1composeidgs904.ui.theme.Ejemplo1ComposeIDGS904Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo1ComposeIDGS904Theme {
                Tarjeta()
            }
        }
    }

    data class Personaje(val nombre: String, val descripcion: String)
    @Composable
    fun Tarjeta() {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            ImagenHeroe()
            Personaje()
        }
    }

    @Composable
    fun Personaje() {
        Column {
            Text("Nombre: Goku")
            Text("Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla.")
        }
    }

    @Composable
    fun ImagenHeroe() {
        Image(
            painterResource(id = R.drawable.celula),
            contentDescription = "Goku",
            modifier = Modifier
                .padding(16.dp)
                .size(100.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
        )
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        Tarjeta()
    }
}