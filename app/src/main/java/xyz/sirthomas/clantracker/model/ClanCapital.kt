package xyz.sirthomas.clantracker.model

import kotlinx.serialization.Serializable

@Serializable
data class ClanCapital(
    val capitalHallLevel: Int,
    val districts: List<District>,
)

@Serializable
data class District(
    val id: Int,
    val name: String,
    val districtHallLevel: Int,
)