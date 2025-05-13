package data.models

import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val name: Name,
    val capital: List<String>? = null,
    val flags: Flags,
    val population: Int? = null,
    val region: String? = null,
    val subregion: String? = null
)

@Serializable
data class Name(
    val common: String
)

@Serializable
data class Flags(
    val png: String
)
