
package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.Shapes
import com.example.superheroes.ui.theme.SuperheroesTheme



@Composable
fun HeroList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(HeroesRepository.heroes) { item ->
            HeroItem(item)
        }
    }

}
@Composable
fun HeroItem(hero: Hero,
             modifier: Modifier = Modifier
) {
    Card(
        shape = Shapes.medium
    ) {
        Row(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()

        ) {
            Column(
                modifier = modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall,

                )
                Text(
                    text =  stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }

            Spacer(
                modifier
                    .width(16.dp)
            )
            Box(
                modifier = modifier
                    .size(width = 72.dp, height = 72.dp)
                    .clip(Shapes.small)
            ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = "",
                    modifier
                        .fillMaxSize()

                )
            }


        }
    }
}


@Preview
@Composable
fun Preview() {
    SuperheroesTheme {
        HeroList()
    }
}

