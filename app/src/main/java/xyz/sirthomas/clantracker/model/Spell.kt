package xyz.sirthomas.clantracker.model

import kotlinx.serialization.Serializable

@Serializable
data class Spell(
    val name: String,
    val level: Int,
    val maxLevel: Int,
    val village: String,
)