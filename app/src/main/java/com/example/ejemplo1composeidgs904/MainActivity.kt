package com.example.ejemplo1composeidgs904

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class PersonajeTarjeta(val imagen: Int, val title: String, val body: String)

private val personajes = listOf(
    PersonajeTarjeta(R.drawable.goku, "Goku", "El protagonista de la serie."),
    PersonajeTarjeta(R.drawable.gohan, "Gohan", "Es el primer hijo de Son Goku y Chi-Chi"),
    PersonajeTarjeta(R.drawable.bulma, "Bulma", "Bulma es la protagonista femenina de la serie manga Dragon Ball."),
    PersonajeTarjeta(R.drawable.freezer, "Freezer", "Freezer es el tirano espacial y el principal antagonista de la saga."),
    PersonajeTarjeta(R.drawable.celula, "Cell", "Es un bioandroide."),
    PersonajeTarjeta(R.drawable.vegeta, "Vegeta", "Príncipe de los Saiyans"),
    PersonajeTarjeta(R.drawable.krilin, "Krillin", "Amigo cercano de Goku y guerrero valiente."),
    PersonajeTarjeta(R.drawable.piccolo, "Piccolo", "Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre"),
    PersonajeTarjeta(R.drawable.roshi, "Maestro Roshi", "Maestro de artes marciales y mentor de Goku."),
    PersonajeTarjeta(R.drawable.yamcha, "Yamcha", "Luchador que solía ser un bandido del desierto."),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme{
                ListaDeTarjetas(personajes)
            }
        }
    }
}

@Composable
fun ListaDeTarjetas(personajes: List<PersonajeTarjeta>) {
    LazyColumn {
        items(personajes) { personaje ->
            MyPersonajeCard(personaje)
        }
    }
}

@Composable
fun MyPersonajeCard(personaje: PersonajeTarjeta) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp)
        ) {
            ImagenHeroe(imageId = personaje.imagen, contentDescription = personaje.title)
            InfoPersonaje(personaje)
        }
    }
}

@Composable
fun InfoPersonaje(personaje: PersonajeTarjeta) {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        TextoEstilizado(
            texto = personaje.title,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge
        )
        TextoEstilizado(
            texto = personaje.body,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun TextoEstilizado(texto: String, color: Color, style: androidx.compose.ui.text.TextStyle) {
    Text(
        text = texto,
        color = color,
        style = style
    )
}

@Composable
fun ImagenHeroe(imageId: Int, contentDescription: String?) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = contentDescription,
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    AppTheme {
        ListaDeTarjetas(personajes)
    }
}