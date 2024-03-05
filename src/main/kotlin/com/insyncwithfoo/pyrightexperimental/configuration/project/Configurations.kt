package com.insyncwithfoo.pyrightexperimental.configuration.project

import com.intellij.openapi.components.BaseState
import org.jetbrains.annotations.SystemDependent


class Configurations : BaseState() {
    
    var projectExecutable by string(null)
    
    companion object {
        fun create(
            projectExecutable: @SystemDependent String?
        ) =
            Configurations().apply {
                this.projectExecutable = projectExecutable
            }
    }
    
}
