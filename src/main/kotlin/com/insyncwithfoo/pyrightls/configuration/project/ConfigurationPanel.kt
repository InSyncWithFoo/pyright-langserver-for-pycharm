package com.insyncwithfoo.pyrightls.configuration.project

import com.insyncwithfoo.pyrightls.configuration.common.PyrightLSConfigurationPanel
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import javax.swing.JLabel
import javax.swing.JPanel


class ConfigurationPanel(private val project: Project) : PyrightLSConfigurationPanel<Configurations>() {
    
    override lateinit var panel: JPanel
    
    private lateinit var projectExecutableLabel: JLabel
    private lateinit var projectExecutableInput: TextFieldWithBrowseButton
    
    override val textFieldsWithBrowseButtons: List<TextFieldWithBrowseButton>
        get() = listOf(projectExecutableInput)
    
    init {
        setLabels()
        addBrowseButtonListeners()
        applyExistingConfigurations()
    }
    
    override var configurations: Configurations
        get() = Configurations.create(
            projectExecutable = projectExecutableInput.text.takeIf { it.isNotBlank() }
        )
        set(value) {
            projectExecutableInput.text = value.projectExecutable.orEmpty()
        }
    
    override fun getService() = ConfigurationService.getInstance(project)
    
    override fun setLabels() {
        projectExecutableLabel.text = "Project executable:"
    }
    
}
