package com.insyncwithfoo.pyrightls

import com.insyncwithfoo.pyrightls.configuration.PyrightLSAllConfigurations
import com.insyncwithfoo.pyrightls.configuration.PyrightLSConfigurationService
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.profile.codeInspection.InspectionProjectProfileManager
import java.nio.file.Path


internal val Project.path: Path?
    get() = basePath?.let { Path.of(it) }


private val Project.sdk: Sdk?
    get() = ProjectRootManager.getInstance(this).projectSdk


internal val Project.sdkPath: Path?
    get() = sdk?.homePath?.let { Path.of(it) }


internal val Project.pyrightLSConfigurations: PyrightLSAllConfigurations
    get() = PyrightLSConfigurationService.getInstance(this).configurations


internal fun Project.isPyrightLSInspectionEnabled(): Boolean {
    val inspectionManager = InspectionProjectProfileManager.getInstance(this)
    val profile = inspectionManager.currentProfile
    val pyrightLSInspection = profile.allTools.find { it.tool.shortName == PyrightLSInspection.SHORT_NAME }
    
    return pyrightLSInspection?.isEnabled ?: false
}
