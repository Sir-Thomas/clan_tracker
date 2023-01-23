package xyz.sirthomas.clantracker.model

import kotlinx.serialization.Serializable

@Serializable
data class League(
    val id: Int,
    val name: String,
    val iconUrls: LeagueIconUrls? = null,
)

@Serializable
data class LeagueIconUrls(
    val tiny: String? = null,
    val small: String? = null,
    val medium: String? = null,
)