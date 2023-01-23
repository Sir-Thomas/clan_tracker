package xyz.sirthomas.clantracker.model

import kotlinx.serialization.Serializable

@Serializable
data class Label(
    val id: Int,
    val name: String,
    val iconUrls: LabelIconUrls,
)

@Serializable
data class LabelIconUrls(
    val small: String,
    val medium: String,
)