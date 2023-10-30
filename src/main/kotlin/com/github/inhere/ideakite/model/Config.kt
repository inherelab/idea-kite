package com.github.inhere.ideakite.model

import kotlinx.serialization.Serializable

@Serializable
data class Config(
    val groups: List<Group>
)