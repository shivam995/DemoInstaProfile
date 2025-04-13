package com.learnings.demo.insta.profile.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.learnings.demo.insta.profile.domain.model.UserProfile

@Composable
fun ProfileHeader(profile: UserProfile) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = profile.profileImageUrl,
                contentDescription = "Profile",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(24.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("${profile.posts}", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("Posts", fontSize = 12.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("${profile.followers}", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("Followers", fontSize = 12.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("${profile.following}", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("Following", fontSize = 12.sp)
                }
            }
        }

        Spacer(Modifier.height(8.dp))
        Text(profile.name, fontWeight = FontWeight.Bold)
        Text(profile.bio)
        Spacer(Modifier.height(4.dp))
        Text(profile.username, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)

        Spacer(Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                shape = RoundedCornerShape(corner = CornerSize(24)),
                modifier = Modifier
                    .weight(1f)
                    .height(35.dp),
                onClick = {}) {
                Text(
                    "Edit Profile",
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedButton(
                shape = RoundedCornerShape(corner = CornerSize(24)),
                modifier = Modifier
                    .weight(1f)
                    .height(35.dp),
                onClick = {}) {
                Text(
                    "Share Profile",
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedButton(
                shape = RoundedCornerShape(corner = CornerSize(24)),
                contentPadding = PaddingValues(2.dp),
                modifier = Modifier
                    .weight(0.25f)
                    .height(35.dp),
                onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    tint = Color.Black,
                    contentDescription = "Follow People",
                )
            }
        }
    }
}
