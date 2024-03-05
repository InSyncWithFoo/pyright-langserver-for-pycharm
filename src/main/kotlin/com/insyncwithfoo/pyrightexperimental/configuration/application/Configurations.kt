package com.insyncwithfoo.pyrightexperimental.configuration.application

import com.intellij.openapi.components.BaseState
import org.jetbrains.annotations.SystemDependent


class Configurations : BaseState() {
    
    var alwaysUseGlobal by property(false)
    var globalExecutable by string(null)
    
    companion object {
        fun create(
            alwaysUseGlobal: Boolean,
            globalExecutable: @SystemDependent String?
        ) =
            Configurations().apply {
                this.alwaysUseGlobal = alwaysUseGlobal
                this.globalExecutable = globalExecutable
            }
    }
    
}
