package com.github.inhere.ideakite

import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.Content
import com.intellij.ui.content.ContentFactory
import com.github.inhere.ideakite.configurations.AppConfigurationProvider
import com.github.inhere.ideakite.terminal.IntellijIDETerminal
import com.github.inhere.ideakite.ui.CliActionsTablePanel

class IdeaKiteToolWindowFactory : DumbAware, ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val terminalProvider = IntellijIDETerminal(project)
        val configurationFinder = AppConfigurationProvider(project)

        val cmdPanel = CliActionsTablePanel(
            configurationFinder = configurationFinder,
            runTerminalCommand = { name, command -> terminalProvider.run(name, command) }
        )
        val content: Content = ContentFactory.getInstance().createContent(cmdPanel, null, true)
        content.setDisposer(cmdPanel::dispose)
        content.preferredFocusableComponent = cmdPanel
        toolWindow.contentManager.addContent(content)
        cmdPanel.initialise()
    }
}