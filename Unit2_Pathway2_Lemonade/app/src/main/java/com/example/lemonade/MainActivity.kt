package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }
    val imageResource = when(currentStep) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> {R.drawable.lemon_tree}
    }
    val textId = when(currentStep) {
        1 -> R.string.step1_description
        2 -> R.string.step2_description
        3 -> R.string.step3_description
        4 -> R.string.step4_description
        else -> R.string.step1_description
    }
    val pressHandle: () -> Unit ={
        if(currentStep == 2) {
            val ran = (1..3).random()
            if (ran ==1) currentStep = 3
        }
        else if(currentStep == 1) currentStep = 2;
        else if(currentStep == 3) currentStep = 4;
        else currentStep = 1;

    }
    StepView(stringResource(textId), imageResource, onPress = pressHandle)
}

@Composable
fun StepView(text: String, imgId: Int,modifier: Modifier = Modifier, onPress: () -> Unit) {
    val shape = RoundedCornerShape(24.dp)
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .background(color = Color.Yellow)
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center,

        ) {
            Text(
                text = "Lemonade"
            )
        }
        Column (
            Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(shape)
                    .background(Color.Cyan)
                    .padding(8.dp)
                    .clickable(true, onClick =  {onPress()}),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(imgId),
                    contentDescription = ""

                )
            }
            Spacer(
                Modifier.height(16.dp)
            )
            Text(
                text = text
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Preview() {
    LemonadeTheme {
        LemonadeApp()
    }
}