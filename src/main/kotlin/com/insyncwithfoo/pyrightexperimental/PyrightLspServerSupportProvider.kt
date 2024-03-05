package com.insyncwithfoo.pyrightexperimental

import com.insyncwithfoo.pyrightexperimental.configuration.PyrightConfigurationService
import com.intellij.codeInspection.ex.InspectionToolRegistrar
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.profile.codeInspection.ProjectInspectionProfileManager
import java.io.File


private val Project.isPyrightLSEnabled: Boolean
    get() {
        val inspectionProfileManager = ProjectInspectionProfileManager.getInstance(this)
        val toolWrapper = InspectionToolRegistrar.getInstance().createTools()
            .find { it.shortName == PyrightInspection.SHORT_NAME } ?: return false
        
        return inspectionProfileManager.currentProfile.isToolEnabled(toolWrapper.displayKey)
    }


@Suppress("UnstableApiUsage")
class PyrightLspServerSupportProvider : LspServerSupportProvider {

    override fun fileOpened(
        project: Project,
        file: VirtualFile,
        serverStarter: LspServerSupportProvider.LspServerStarter
    ) {
        if (file.extension != "py" || !project.isPyrightLSEnabled) {
            return
        }
        
        val configurationService = PyrightConfigurationService.getInstance(project)
        val configurations = configurationService.configurations
        val executable = File(configurations.executable ?: return)
            .takeIf { it.exists() } ?: return

        val descriptor = PyrightLspServerDescriptor(project, executable)

        serverStarter.ensureServerStarted(descriptor)
    }

}
