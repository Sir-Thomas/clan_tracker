package xyz.sirthomas.clantracker.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import xyz.sirthomas.clantracker.R

val YouBlockhead = FontFamily(
    Font(R.font.ccyoublockhead)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
      fontFamily = YouBlockhead,
      fontWeight = FontWeight.Normal,
      fontSize = 32.sp
    ),
    h2 = TextStyle(
        fontFamily = YouBlockhead,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    h3 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)