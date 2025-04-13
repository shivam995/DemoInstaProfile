package com.learnings.demo.insta.profile.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.learnings.demo.insta.profile.domain.model.Highlight

@Composable
fun StoryHighlights(highlights: List<Highlight>) {
    val rememberHighlights = remember(highlights) { highlights }

    LazyRow(contentPadding = PaddingValues(16.dp)) {
        items(rememberHighlights, key = { it.id }) { highlight ->
            StoryHighlightItemView(highlight)
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}

@Composable
fun StoryHighlightItemView(highlight: Highlight) {
    return Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .padding(2.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(2.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(highlight.imageUrl)
                    .crossfade(true)
                    .crossfade(200)
                    .memoryCacheKey("highlight_${highlight.id}")
                    .diskCacheKey("highlight_${highlight.id}")
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop

            )
        }
        Spacer(Modifier.height(4.dp))
        Text(text = highlight.title, fontSize = 11.sp)
        Spacer(Modifier.height(4.dp))
    }
}
