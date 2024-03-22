package com.insyncwithfoo.pyrightls.configuration

import com.insyncwithfoo.pyrightls.configuration.project.ConfigurationService
import com.intellij.openapi.project.Project
import com.insyncwithfoo.pyrightls.configuration.application.ConfigurationService as ApplicationConfigurationService
import com.insyncwithfoo.pyrightls.configuration.project.ConfigurationService as ProjectConfigurationService


internal class PyrightLSConfigurationService private constructor(
    applicationService: ApplicationConfigurationService,
    val projectService: ProjectConfigurationService
) {
    
    val configurations = applicationService.configurations mergeWith projectService.configurations
    
    companion object {
        fun getInstance(project: Project): PyrightLSConfigurationService {
            val applicationService = ApplicationConfigurationService.getInstance()
            val projectService = ConfigurationService.getInstance(project)
            
            return PyrightLSConfigurationService(applicationService, projectService)
        }
    }
    
}
