package com.insyncwithfoo.pyrightls.configuration

import org.jetbrains.annotations.SystemDependent
import com.insyncwithfoo.pyrightls.configuration.application.Configurations as ApplicationConfigurations
import com.insyncwithfoo.pyrightls.configuration.project.Configurations as ProjectConfigurations


internal infix fun ApplicationConfigurations.mergeWith(other: ProjectConfigurations) =
    PyrightLSAllConfigurations(
        alwaysUseGlobal = this.alwaysUseGlobal,
        globalExecutable = this.globalExecutable,
        
        projectExecutable = other.projectExecutable,
        autoSuggestExecutable = other.autoSuggestExecutable
    )


internal data class PyrightLSAllConfigurations(
    val alwaysUseGlobal: Boolean,
    val globalExecutable: @SystemDependent String?,
    
    val projectExecutable: @SystemDependent String?,
    val autoSuggestExecutable: Boolean
) {
    val executable: @SystemDependent String?
        get() = when {
            alwaysUseGlobal -> globalExecutable
            else -> projectExecutable ?: globalExecutable
        }
}
