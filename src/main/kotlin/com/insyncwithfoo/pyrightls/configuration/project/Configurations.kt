package com.insyncwithfoo.pyrightls.configuration.project

import com.intellij.openapi.components.BaseState
import org.jetbrains.annotations.SystemDependent


internal class Configurations : BaseState() {
    
    var projectExecutable by string(null)
    var autoSuggestExecutable by property(true)
    
    companion object {
        fun create(
            projectExecutable: @SystemDependent String?,
            autoSuggestExecutable: Boolean
        ) =
            Configurations().apply {
                this.projectExecutable = projectExecutable
                this.autoSuggestExecutable = autoSuggestExecutable
            }
    }
    
}
