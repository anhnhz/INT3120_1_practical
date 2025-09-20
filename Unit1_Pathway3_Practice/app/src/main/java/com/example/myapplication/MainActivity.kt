package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.lang.ref.Reference

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReferenceApp()
        }
    }
}

@Composable
fun Quadrant(title: String, content: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ReferenceApp() {
    Column() {
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = "Text composable",
                content = "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(color = Color(0xFFEADDFF))// màu nền
            )
            Quadrant(
                title = "Image composable",
                content = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color(0xFFD0BCFF))
            )
        }
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = "Row composable",
                content = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color(0xFFB69DF8))
            )
            Quadrant(
                title = "Column composable",
                content = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color(0xFFF6EDFF))
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun QuadrantPreview() {
    ReferenceApp()
}



@Composable
fun TaskManagerApp() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = "tick_image"
        )
        Text(
            text = "All tasks completed",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = "Nice work!",
            fontSize = 16.sp
        )
    }
}

@Composable
fun LearnTogetherApp() {
    Column() {
        Image(
            painter = painterResource(R.drawable.bg_compose_background),
            modifier = Modifier.fillMaxWidth(),
            contentDescription= "background",
        )
        Text(
            text = "Jetpack Compose tutorial",
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp,

        )
        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            modifier= Modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}

