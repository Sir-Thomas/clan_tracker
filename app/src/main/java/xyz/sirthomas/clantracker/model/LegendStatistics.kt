package xyz.sirthomas.clantracker.model

import kotlinx.serialization.Serializable

@Serializable
data class LegendStatistics(
    val legendTrophies: Int,
    val bestSeason: LegendSeason? = null,
    val bestVersusSeason: LegendSeason? = null,
    val currentSeason: LegendSeason,
    val previousSeason: LegendSeason? = null,
)

@Serializable
data class LegendSeason(
    val id: String? = null,
    val rank: Int? = null,
    val trophies: Int,
)