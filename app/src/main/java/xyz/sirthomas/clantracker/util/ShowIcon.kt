package xyz.sirthomas.clantracker.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import xyz.sirthomas.clantracker.R

@Composable
fun ShowIcon(url: String?) {
    if (url != null) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(url)
                .crossfade(true)
                .build(),
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
    }
}