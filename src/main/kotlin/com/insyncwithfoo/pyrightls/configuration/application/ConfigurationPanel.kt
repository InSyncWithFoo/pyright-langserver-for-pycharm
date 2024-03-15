package com.insyncwithfoo.pyrightls.configuration.application

import com.insyncwithfoo.pyrightls.configuration.common.PyrightLSConfigurationPanel
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import javax.swing.JCheckBox
import javax.swing.JLabel
import javax.swing.JPanel


class ConfigurationPanel : PyrightLSConfigurationPanel<Configurations>() {
    
    override lateinit var panel: JPanel
    
    private lateinit var alwaysUseGlobalInput: JCheckBox
    
    private lateinit var globalExecutableLabel: JLabel
    private lateinit var globalExecutableInput: TextFieldWithBrowseButton
    
    override val textFieldsWithBrowseButtons: List<TextFieldWithBrowseButton>
        get() = listOf(globalExecutableInput)
    
    init {
        setLabels()
        addBrowseButtonListeners()
        applyExistingConfigurations()
    }
    
    override var configurations: Configurations
        get() = Configurations.create(
            alwaysUseGlobal = alwaysUseGlobalInput.isSelected,
            globalExecutable = globalExecutableInput.text.takeIf { it.isNotBlank() }
        )
        set(value) {
            alwaysUseGlobalInput.isSelected = value.alwaysUseGlobal
            globalExecutableInput.text = value.globalExecutable.orEmpty()
        }
    
    override fun getService() = ConfigurationService.getInstance()
    
    override fun setLabels() {
        alwaysUseGlobalInput.text = "Always use global executable"
        globalExecutableLabel.text = "Global executable:"
    }
    
}
