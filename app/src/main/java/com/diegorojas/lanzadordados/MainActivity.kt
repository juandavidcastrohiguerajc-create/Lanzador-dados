package com.diegorojas.lanzadordados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.diegorojas.lanzadordados.ui.theme.LanzadorDadosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LanzadorDadosTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LanzadorDadosApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LanzadorDadosApp() {
    DadoConBotonEImagen(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DadoConBotonEImagen(modifier: Modifier = Modifier) {
    var resultado by remember { mutableIntStateOf(1) }

    // se escoge la imagen segun el numero que salio
    val imagen = when (resultado) {
        1 -> R.drawable.dado_1
        2 -> R.drawable.dado_2
        3 -> R.drawable.dado_3
        4 -> R.drawable.dado_4
        5 -> R.drawable.dado_5
        else -> R.drawable.dado_6
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.nombre_estudiante),
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = painterResource(imagen),
            contentDescription = stringResource(R.string.descripcion_dado, resultado)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { resultado = (1..6).random() }) {
            Text(stringResource(R.string.lanzar))
        }
    }
}
