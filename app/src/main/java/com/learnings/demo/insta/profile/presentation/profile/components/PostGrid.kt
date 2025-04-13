package com.learnings.demo.insta.profile.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.learnings.demo.insta.profile.domain.model.Post

@Composable
fun PostGrid(posts: List<Post>) {
    val rememberPosts = remember(posts) { posts }
    val columns = 3
    val rowCount = (posts.size + columns - 1) / columns
    val gridHeight = (rowCount * 120).dp + 100.dp

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        userScrollEnabled = false,
        modifier = Modifier
            .fillMaxWidth()
            .height(gridHeight)
    ) {
        items(rememberPosts, key = ({ it.id })) { post ->
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(post.imageUrl)
                    .crossfade(true)
                    .crossfade(200)
                    .memoryCacheKey("post_${post.id}")
                    .diskCacheKey("post_${post.id}")
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
                    .padding(0.5.dp)
                    .background(Color.LightGray)

            )
        }
    }
}


