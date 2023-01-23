package xyz.sirthomas.clantracker.model

import kotlinx.serialization.Serializable

@Serializable
data class Player(
    val tag: String,
    val name: String,
    val townHallLevel: Int,
    val townHallWeaponLevel: Int = 0,
    val expLevel: Int,
    val trophies: Int,
    val bestTrophies: Int,
    val warStars: Int,
    val attackWins: Int,
    val defenseWins: Int,
    val builderHallLevel: Int = 0,
    val versusTrophies: Int,
    val bestVersusTrophies: Int,
    val versusBattleWins: Int,
    val role: String? = null,
    val warPreference: String? = null,
    val donations: Int,
    val donationsReceived: Int,
    val clanCapitalContributions: Int,
    val clan: Clan? = null,
    val league: League? = null,
    val legendStatistics: LegendStatistics? = null,
    val achievements: List<Achievement>,
    val playerHouse: PlayerHouse? = null,
    val versusBattleWinCount: Int,
    val labels: List<Label>,
    val troops: List<Troop>,
    val heroes: List<Hero>,
    val spells: List<Spell>,
)

