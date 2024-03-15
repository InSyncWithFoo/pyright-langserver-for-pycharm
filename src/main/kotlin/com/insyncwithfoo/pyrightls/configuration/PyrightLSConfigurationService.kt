package com.insyncwithfoo.pyrightls.configuration

import com.insyncwithfoo.pyrightls.configuration.project.ConfigurationService
import com.intellij.openapi.project.Project
import org.jetbrains.annotations.SystemDependent
import com.insyncwithfoo.pyrightls.configuration.application.ConfigurationService as ApplicationConfigurationService
import com.insyncwithfoo.pyrightls.configuration.project.ConfigurationService as ProjectConfigurationService


internal data class PyrightLSAllConfigurations(
    val alwaysUseGlobal: Boolean = false,
    val globalExecutable: @SystemDependent String? = null,
    
    val projectExecutable: @SystemDependent String? = null,
) {
    val executable: @SystemDependent String?
        get() = when {
            alwaysUseGlobal -> globalExecutable
            else -> projectExecutable ?: globalExecutable
        }
}


internal class PyrightLSConfigurationService private constructor(
    applicationService: ApplicationConfigurationService,
    projectService: ProjectConfigurationService
) {
    
    val configurations: PyrightLSAllConfigurations
    
    init {
        val applicationConfigurations = applicationService.configurations
        val projectConfigurations = projectService.configurations
        
        configurations = PyrightLSAllConfigurations(
            alwaysUseGlobal = applicationConfigurations.alwaysUseGlobal,
            globalExecutable = applicationConfigurations.globalExecutable,
            
            projectExecutable = projectConfigurations.projectExecutable
        )
    }
    
    companion object {
        fun getInstance(project: Project): PyrightLSConfigurationService {
            val applicationService = ApplicationConfigurationService.getInstance()
            val projectService = ConfigurationService.getInstance(project)
            
            return PyrightLSConfigurationService(applicationService, projectService)
        }
    }
    
}
