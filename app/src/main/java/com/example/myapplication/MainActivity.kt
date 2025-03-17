package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                   Surface (
                       modifier = Modifier.fillMaxSize(),
                       color = MaterialTheme.colorScheme.background
                   )
                   {
                       greetingImage(
                           message = "ola",
                           from = "From junior"
                       )

            }
        }
    }
}



@Composable
fun greetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.joinha)

    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(message, from,
            modifier = Modifier.fillMaxSize()
                .padding(8.dp)
                .background(color = Color.Cyan))
    }
}

@Composable
fun GreetingText(message: String,from: String,modifier: Modifier = Modifier){

    Column(modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center) {
        Text(
            text = message,
            fontSize = 10.sp,
            lineHeight = 10.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = from,
            fontSize = 7.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        greetingImage(message = "Ola, tudo bem ?", from = "From Admar")

    }
}
}

