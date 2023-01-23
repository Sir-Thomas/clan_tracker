package xyz.sirthomas.clantracker.model

import kotlinx.serialization.Serializable

@Serializable
data class Clan(
    val tag: String,
    val name: String,
    val clanLevel: Int,
    val badgeUrls: BadgeUrls,
)

@Serializable
data class BadgeUrls(
    val small: String,
    val medium: String,
    val large: String,
)
