package com.example.artspaceapp

import android.hardware.lights.Light
import androidx.compose.runtime.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                ArtSpaceApp()
            }
        }
    }
}
data class ArtItem(
    val imageId: Int,
    val title: String,
    val artist: String
)

@Composable
fun ArtSpaceApp() {
    val artList = listOf(
        ArtItem(R.drawable.img1, "Buffalo Children", "NoName (2017)"),
        ArtItem(R.drawable.img2, "Morning Light", "Noname (2020)"),
        ArtItem(R.drawable.img3, "Silent Forest", "Me (2027)")
    )

    var currentIndex by remember { mutableIntStateOf(0) }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
        modifier = Modifier.align(Alignment.Center)
        ) {
            ArtView(artList[currentIndex].imageId)
            TitleView(artList[currentIndex].title, artList[currentIndex].artist)
        }
        ButtonView(
            modifier = Modifier.align(Alignment.BottomCenter),

            onPrevious = {
                currentIndex = if (currentIndex > 0) currentIndex - 1 else artList.lastIndex
            },
            onNext = {
                currentIndex = (currentIndex + 1)%3
            }
        )
    }
}

@Composable
fun ArtView(imgId: Int) {
    Box(
        modifier = Modifier.padding(horizontal = 26.dp)
            .padding(top = 8.dp)
            .padding(bottom = 32.dp)
    ) {
        Image(
            painter = painterResource(imgId),
            contentDescription = ""
        )
    }
}
@Composable
fun TitleView(title: String, artist: String) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,

    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFFEFEFEF))
                .padding(12.dp),

        ) {
            Text(
                text = title,
                fontSize = 35.sp,
                fontWeight = FontWeight.Light,
            )
            Text(
                text = artist,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ButtonView(modifier: Modifier = Modifier,
        onPrevious: () -> Unit,
        onNext: () -> Unit) {
    Row (
        modifier = modifier.fillMaxWidth()
            .padding(bottom = 50.dp)
            .padding(horizontal = 20.dp)

    ) {
        Button(
            onClick = onPrevious,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        ) {
            Text(
                text = "Previous"
            )
        }
        Button(
            onClick = onNext,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        ) {
            Text(
                text = "Next"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ArtSpaceApp()
}