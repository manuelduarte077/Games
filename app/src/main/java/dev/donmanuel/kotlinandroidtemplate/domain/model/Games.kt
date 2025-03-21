package dev.donmanuel.kotlinandroidtemplate.domain.model

data class Games(
    val developers: List<String>,
    val genre: List<String>,
    val id: Int,
    val name: String,
    val publishers: List<String>,
    val releaseDates: Map<String, String>
)