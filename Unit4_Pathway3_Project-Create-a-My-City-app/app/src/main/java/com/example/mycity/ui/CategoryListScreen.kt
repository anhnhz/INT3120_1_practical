package com.example.mycity.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.DataResources
import com.example.mycity.model.Location
import com.example.mycity.ui.theme.MyCityTheme

enum class Category(
    @StringRes val stringResId: Int,
    val resourcesList: List<Location>
) {
    CoffeeShops(
        R.string.category_1,
        DataResources.getCafeList()
    ),
    Restaurants(
        R.string.category_2,
        DataResources.getRestaurantList()
    ),
    KidFriendlyPlaces(
        R.string.category_3,
        DataResources.getKidsList()
    ),
    Parks(
        R.string.category_4,
        DataResources.getParkList()
    ),
    ShoppingCenters(
        R.string.category_5,
        DataResources.getMallList()
    );
}


@Composable
fun CategoryListScreen(
    onCategoryClick: (Category) -> Unit
) {

    val data: List<Category> = Category.entries

    LazyColumn {  items(data) { item ->
        CategoryItem(
            category = item,
            onClick = {onCategoryClick(item)},
        )
    }

    }
}

@Composable
fun BaseListItem(
    nameRes: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = stringResource(id = nameRes),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    BaseListItem(
        nameRes = category.stringResId,
        modifier = modifier,
        onClick = onClick
    )
}




