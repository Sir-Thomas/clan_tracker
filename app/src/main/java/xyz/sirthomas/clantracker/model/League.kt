package xyz.sirthomas.clantracker.model

import kotlinx.serialization.Serializable

@Serializable
data class League(
    val id: Int,
    val name: String,
    val iconUrls: LeagueIconUrls,
)

@Serializable
data class LeagueIconUrls(
    val tiny: String,
    val small: String,
    val medium: String,
)