package com.learnings.demo.insta.profile.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.learnings.demo.insta.profile.domain.model.UserProfile

@Composable
fun ProfileHeader() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(""),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(16.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("100", fontWeight = FontWeight.Bold)
                    Text("Posts")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("210", fontWeight = FontWeight.Bold)
                    Text("Followers")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("$300", fontWeight = FontWeight.Bold)
                    Text("Following")
                }
            }
        }

        Spacer(Modifier.height(8.dp))
        Text("_myselfshivam", fontWeight = FontWeight.Bold)
        Text("bio")

        Spacer(Modifier.height(8.dp))
        Row {
            Button(modifier = Modifier.weight(1f), onClick = {}) { Text("Follow") }
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedButton(modifier = Modifier.weight(1f), onClick = {}) { Text("Message") }
        }
    }
}
