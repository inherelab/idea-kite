package com.github.inhere.ideakite.model

import com.github.inhere.ideakite.model.Command
import kotlinx.serialization.Serializable

@Serializable
data class Group(
    val name: String,
    val commands: List<Command>
)