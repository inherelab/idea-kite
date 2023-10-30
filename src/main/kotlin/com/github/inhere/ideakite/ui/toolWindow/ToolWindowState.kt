package com.github.inhere.ideakite.ui.toolWindow

import com.github.inhere.ideakite.model.Group

/**
 * class ToolWindowState
 */
sealed class ToolWindowState {
    data class Loading(val message: String) : ToolWindowState()
    data class Error(val message: String): ToolWindowState()
    data class Content(val groups: List<Group>): ToolWindowState()
}
