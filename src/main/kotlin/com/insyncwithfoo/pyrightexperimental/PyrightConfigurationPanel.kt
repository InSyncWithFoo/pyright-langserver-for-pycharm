package com.insyncwithfoo.pyrightexperimental

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import javax.swing.JLabel
import javax.swing.JPanel

class PyrightConfigurationPanel(project: Project) {

    private lateinit var panel: JPanel

    private lateinit var executableLabel: JLabel
    private lateinit var executableInput: TextFieldWithBrowseButton

    init {
        setLabels()
        addListeners()

        val service = PyrightConfigurationService.getInstance(project)
        executableInput.text = service.executable ?: ""
    }

    internal val component
        get() = panel

    val executable: String?
        get() = executableInput.text.takeIf { it.isNotBlank() }

    private fun setLabels() {
        executableLabel.text = "Executable:"
    }

    private fun addListeners() {
        executableInput.apply {
            addBrowseFolderListener(
                null, null, null,
                FileChooserDescriptorFactory.createSingleFileDescriptor()
            )
        }
    }

}
