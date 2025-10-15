package com.example.amphibians.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.model.AmphibianPhoto


@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues,
) {
    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is AmphibiansUiState.Success -> AmphibianGallery(
            photoList = amphibiansUiState.photos,
            contentPadding = contentPadding
        )
        AmphibiansUiState.Error -> LoadingScreen(modifier = modifier.fillMaxSize())
    }
}


@Composable
fun AmphibianPhotoCard(photo: AmphibianPhoto, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)), // bo góc
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFADFF2F) // màu xanh lá mạ (lime green)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = "${photo.name} (${photo.type})",
                style = MaterialTheme.typography.titleMedium
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(photo.imgSrc)
                    .crossfade(true)
                    .build(),
                error = painterResource(R.drawable.ic_connection_error),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)) // bo góc cho ảnh
            )
            Text(
                text = photo.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun AmphibianGallery(
    photoList: List<AmphibianPhoto>,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = contentPadding
    ) {
        items(photoList) { photo ->
            AmphibianPhotoCard(photo = photo)
        }
    }
}



@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = " "
    )
}
