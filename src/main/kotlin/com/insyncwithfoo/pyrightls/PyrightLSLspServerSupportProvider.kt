package com.insyncwithfoo.pyrightls

import com.insyncwithfoo.pyrightls.configuration.PyrightLSConfigurationService
import com.intellij.codeInspection.ex.InspectionToolRegistrar
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.profile.codeInspection.ProjectInspectionProfileManager
import java.nio.file.Path
import kotlin.io.path.exists


private val Project.isPyrightLSEnabled: Boolean
    get() {
        val inspectionProfileManager = ProjectInspectionProfileManager.getInstance(this)
        val toolWrapper = InspectionToolRegistrar.getInstance().createTools()
            .find { it.shortName == PyrightLSInspection.SHORT_NAME } ?: return false
        
        return inspectionProfileManager.currentProfile.isToolEnabled(toolWrapper.displayKey)
    }


private val Project.pyrightLSExecutable: Path?
    get() {
        val projectPath = Path.of(basePath ?: "")
        
        val configurationService = PyrightLSConfigurationService.getInstance(this)
        val configurations = configurationService.configurations
        
        return projectPath.resolve(configurations.executable ?: return null).normalize()
    }


@Suppress("UnstableApiUsage")
class PyrightLSLspServerSupportProvider : LspServerSupportProvider {
    
    override fun fileOpened(
        project: Project,
        file: VirtualFile,
        serverStarter: LspServerSupportProvider.LspServerStarter
    ) {
        if (file.extension != "py" || !project.isPyrightLSEnabled) {
            return
        }
        
        val executable = project.pyrightLSExecutable?.takeIf { it.exists() } ?: return
        val descriptor = PyrightLSLspServerDescriptor(project, executable)
        
        serverStarter.ensureServerStarted(descriptor)
    }
    
}
