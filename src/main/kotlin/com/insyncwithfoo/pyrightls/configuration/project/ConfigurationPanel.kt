package com.insyncwithfoo.pyrightls.configuration.project

import com.insyncwithfoo.pyrightls.configuration.common.ConfigurationPanel
import com.insyncwithfoo.pyrightls.message
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import javax.swing.JCheckBox
import javax.swing.JLabel
import javax.swing.JPanel


internal class ConfigurationPanel(private val project: Project) : ConfigurationPanel<Configurations>() {
    
    override lateinit var panel: JPanel
    
    private lateinit var projectExecutableLabel: JLabel
    private lateinit var projectExecutableInput: TextFieldWithBrowseButton
    
    private lateinit var autoSuggestExecutableInput: JCheckBox
    
    override val textFieldsWithBrowseButtons: List<TextFieldWithBrowseButton>
        get() = listOf(projectExecutableInput)
    
    init {
        setLabels()
        addBrowseButtonListeners()
        applyExistingConfigurations()
    }
    
    override var configurations: Configurations
        get() = Configurations.create(
            projectExecutable = projectExecutableInput.text.takeIf { it.isNotBlank() },
            autoSuggestExecutable = autoSuggestExecutableInput.isSelected
        )
        set(value) {
            projectExecutableInput.text = value.projectExecutable.orEmpty()
            autoSuggestExecutableInput.isSelected = value.autoSuggestExecutable
        }
    
    override fun getService() = ConfigurationService.getInstance(project)
    
    override fun setLabels() {
        projectExecutableLabel.text = message("configurations.project.projectExecutable.label")
        autoSuggestExecutableInput.text = message("configurations.project.autoSuggestExecutable.label")
    }
    
}
