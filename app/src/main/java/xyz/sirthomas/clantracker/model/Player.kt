package xyz.sirthomas.clantracker.model

import kotlinx.serialization.Serializable

@Serializable
data class Player(
    val tag: String,
    val name: String,
    val townHallLevel: Int? = null,
    val townHallWeaponLevel: Int? = null,
    val expLevel: Int,
    val trophies: Int,
    val bestTrophies: Int? = null,
    val warStars: Int? = null,
    val attackWins: Int? = null,
    val defenseWins: Int? = null,
    val builderHallLevel: Int = 0,
    val versusTrophies: Int,
    val bestVersusTrophies: Int? = null,
    val versusBattleWins: Int? = null,
    val role: String? = null,
    val warPreference: String? = null,
    val clanRank: Int? = null,
    val previousClanRank: Int? = null,
    val donations: Int,
    val donationsReceived: Int,
    val clanCapitalContributions: Int? = null,
    val clan: Clan? = null,
    val league: League? = null,
    val legendStatistics: LegendStatistics? = null,
    val achievements: List<Achievement>? = null,
    val playerHouse: PlayerHouse? = null,
    val versusBattleWinCount: Int? = null,
    val labels: List<Label>? = null,
    val troops: List<Troop>? = null,
    val heroes: List<Hero>? = null,
    val spells: List<Spell>? = null,
)

