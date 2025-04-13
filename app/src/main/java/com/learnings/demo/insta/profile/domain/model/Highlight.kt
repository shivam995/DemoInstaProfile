package com.learnings.demo.insta.profile.domain.model

import java.util.UUID

data class Highlight(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val imageUrl: String
)