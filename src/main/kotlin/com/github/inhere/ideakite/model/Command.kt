package com.github.inhere.ideakite.model

import kotlinx.serialization.Serializable

@Serializable
data class Command(
    val name: String,
    val command: String,
    val prompt: Boolean = false
)