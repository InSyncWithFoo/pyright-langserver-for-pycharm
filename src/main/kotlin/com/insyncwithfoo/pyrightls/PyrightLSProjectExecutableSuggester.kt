package com.insyncwithfoo.pyrightls

import com.insyncwithfoo.pyrightls.configuration.PyrightLSConfigurationService
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity
import java.nio.file.Path
import kotlin.io.path.listDirectoryEntries
import kotlin.io.path.nameWithoutExtension


private val Project.sdkIsLocal: Boolean
    get() = when {
        path == null -> false
        sdkPath == null -> false
        else -> sdkPath!!.startsWith(path!!)
    }

private fun Project.executableShouldBeSuggested(): Boolean {
    val configurations = pyrightLSConfigurations
    
    val suggestionIsEnabled = configurations.autoSuggestExecutable
    val noProjectExecutableGiven = configurations.projectExecutable == null
    val globalExcutableIsPreferred = configurations.alwaysUseGlobal
    
    return suggestionIsEnabled && noProjectExecutableGiven && !globalExcutableIsPreferred
}

private fun Project.findPyrightLSExecutable(): Path? {
    val sdkDirectory = sdkPath?.parent ?: return null
    val children = sdkDirectory.listDirectoryEntries("*")
    
    return children.find { it.nameWithoutExtension == "pyright-langserver" }
}

private fun Project.setAsExecutable(executable: Path) {
    val configurationService = PyrightLSConfigurationService.getInstance(this)
    val projectConfigurations = configurationService.projectService.configurations
    
    projectConfigurations.projectExecutable = executable.toString()
}


private fun Project.disableSuggester() {
    val configurationService = PyrightLSConfigurationService.getInstance(this)
    val projectConfigurations = configurationService.projectService.configurations
    
    projectConfigurations.autoSuggestExecutable = false
}


internal class PyrightLSProjectExecutableSuggester : ProjectActivity {
    
    override suspend fun execute(project: Project) {
        if (project.run { isPyrightLSInspectionEnabled() && executableShouldBeSuggested() && sdkIsLocal }) {
            suggest(project, project.findPyrightLSExecutable() ?: return)
        }
    }
    
    private fun suggest(project: Project, executable: Path) {
        val projectPath = project.path ?: return
        val executableRelativized = projectPath.relativize(executable)
        
        val notification = pyrightNotificationGroup().createNotification(
            title = message("notifications.suggestion.title"),
            content = message("notifications.suggestion.body", executableRelativized),
            NotificationType.INFORMATION
        )
        
        notification.runThenNotify(project) {
            prettify()
            addSimpleExpiringAction(message("notifications.suggestion.action.setAbsolute")) {
                project.setAsExecutable(executable)
            }
            addSimpleExpiringAction(message("notifications.suggestion.action.setRelative")) {
                project.setAsExecutable(executableRelativized)
            }
            addSimpleExpiringAction(message("notifications.error.action.disableSuggester")) {
                project.disableSuggester()
            }
        }
    }
    
}
