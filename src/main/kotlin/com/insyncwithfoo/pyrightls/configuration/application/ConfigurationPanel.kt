package com.insyncwithfoo.pyrightls.configuration.application

import com.insyncwithfoo.pyrightls.configuration.common.ConfigurationPanel
import com.insyncwithfoo.pyrightls.message
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import javax.swing.JCheckBox
import javax.swing.JLabel
import javax.swing.JPanel


internal class ConfigurationPanel : ConfigurationPanel<Configurations>() {
    
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
        alwaysUseGlobalInput.text = message("configurations.global.alwaysUseGlobal.label")
        globalExecutableLabel.text = message("configurations.global.globalExecutable.label")
    }
    
}
