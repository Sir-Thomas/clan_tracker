package xyz.sirthomas.clantracker.model

import kotlinx.serialization.Serializable

@Serializable
data class Clan(
    val tag: String,
    val name: String,
    val type: String? = null,
    val description: String? = null,
    val location: ClanLocation? = null,
    val isFamilyFriendly: Boolean,
    val badgeUrls: BadgeUrls,
    val clanLevel: Int,
    val clanPoints: Int? = null,
    val clanVersusPoints: Int? = null,
    val clanCapitalPoints: Int? = null,
    val capitalLeague: League? = null,
    val requiredTrophies: Int? = null,
    val warFrequency: String? = null,
    val warWinStreak: Int? = null,
    val warWins: Int? = null,
    val warTies: Int? = null,
    val warLosses: Int? = null,
    val isWarLogPublic: Boolean? = null,
    val warLeague: League? = null,
    val members: Int? = null,
    val memberList: List<Player>? = null,
    val labels: List<Label>? = null,
    val requiredVersusTrophies: Int? = null,
    val requiredTownhallLevel: Int? = null,
    val clanCapital: ClanCapital? = null,
    val chatLanguage: ChatLanguage? = null
)

@Serializable
data class ClanLocation(
    val id: Int,
    val name: String,
    val isCountry: Boolean,
    val countryCode: String,
)

@Serializable
data class BadgeUrls(
    val small: String,
    val medium: String,
    val large: String,
)

@Serializable
data class ChatLanguage(
    val id: Int,
    val name: String,
    val languageCode: String,
)

