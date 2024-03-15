package com.insyncwithfoo.pyrightls.configuration.project

import com.insyncwithfoo.pyrightls.configuration.common.PyrightLSConfigurable
import com.intellij.openapi.project.Project
import com.intellij.util.xmlb.XmlSerializerUtil


class PyrightLSProjectConfigurable internal constructor(project: Project) : PyrightLSConfigurable<Configurations>() {
    
    override val service = ConfigurationService.getInstance(project)
    override val panel by lazy { ConfigurationPanel(project) }
    
    override val originalConfigurations: Configurations =
        XmlSerializerUtil.createCopy(service.configurations)
    
    override fun getDisplayName() = DISPLAY_NAME
    
    companion object {
        const val DISPLAY_NAME = "Pyright LS (Project)"
    }
    
}
