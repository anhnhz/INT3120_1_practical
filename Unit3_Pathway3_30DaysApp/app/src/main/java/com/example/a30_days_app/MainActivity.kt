package com.example.a30_days_app

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30_days_app.model.Exercise
import com.example.a30_days_app.model.ExerciseRepository
import com.example.a30_days_app.ui.theme.ThirtyDaysAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThirtyDaysAppTheme {
                TopAppBar()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            )
        }

    ) {innerPadding ->
        ThirtyDaysList(modifier = Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DayItem(exercise: Exercise, modifier: Modifier = Modifier) {
    var mode by remember { mutableStateOf("image") }
    val onClick = {
        mode = if (mode == "image") "text" else "image"
    }
    val shape = RoundedCornerShape(16.dp)

    Card(
        shape = shape
    ) {
        Column(
            modifier.fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = exercise.name,
                style = MaterialTheme.typography.displayMedium
            )

            Box(
                modifier = modifier
                    .clickable { onClick() }
                    .width(300.dp)
                    .height(300.dp)
                    .padding(20.dp),
                contentAlignment = Alignment.Center

            ) {
                AnimatedContent(
                    targetState = mode,
                    transitionSpec = {
                        (fadeIn(tween(300)) with fadeOut(tween(300)))
                    },
                    label = "ExerciseSwitch"
                ) { target ->
                    if (target == "image") {
                        Image(
                            painter = painterResource(exercise.imageRes),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Text(
                            text = stringResource(exercise.descriptionRes),
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .padding(16.dp)
                                .wrapContentSize()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ThirtyDaysList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp)
            .background(Color(MaterialTheme.colorScheme.background.value)),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(ExerciseRepository.exercises) {exercise ->
            DayItem(exercise)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ThirtyDaysAppTheme {
        TopAppBar()
    }
}