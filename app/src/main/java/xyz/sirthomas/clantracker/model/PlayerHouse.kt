package xyz.sirthomas.clantracker.model

import kotlinx.serialization.Serializable

@Serializable
data class PlayerHouse(
    val elements: List<PlayerHouseElement>,
)

@Serializable
data class PlayerHouseElement(
    val type: String,
    val id: Int,
)