package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycity.data.DataResources
import com.example.mycity.model.Location


@Composable
fun LocationDetail(
    location: Location,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Image(
            painter = painterResource(location.imageResId),
            contentDescription = "",
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f),
            contentScale = ContentScale.Crop
        )

        Text(
            text = stringResource(location.descriptionResId),
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier.padding(16.dp)
        )
    }
}

//@Preview
@Composable
fun LocationDetailPreview() {
    LocationDetail(
        location = DataResources.getCafeList()[0]
    )
}




