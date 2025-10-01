package com.example.mycity.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycity.model.Location
import com.example.mycity.ui.theme.MyCityTheme


@Composable
fun LocationListScreen(category: Category,
    onLocationClick: (Location) -> Unit
) {

    val data: List<Location> = category.resourcesList
    LazyColumn {  items(data) { item ->
        LocationItem(
            location = item,
            onClick ={onLocationClick(item)}
        )
    }
    }
}

@Composable
fun LocationItem(
    location: Location,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    BaseListItem(
        nameRes = location.nameResId,
        modifier = modifier,
        onClick = onClick
    )
}
