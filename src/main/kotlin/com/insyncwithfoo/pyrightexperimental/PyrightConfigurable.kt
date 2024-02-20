package com.insyncwithfoo.pyrightexperimental

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import javax.swing.JComponent

class PyrightConfigurable internal constructor(project: Project) : Configurable {

    private val panel = PyrightConfigurationPanel(project)
    private val service = PyrightConfigurationService.getInstance(project)

    override fun getDisplayName() = DISPLAY_NAME

    override fun createComponent(): JComponent {
        reset()
        return panel.component
    }

    override fun isModified() =
        service.executable != panel.executable

    override fun apply() {
        service.executable = panel.executable
    }

    companion object {
        const val DISPLAY_NAME = "Pyright"
    }

}
