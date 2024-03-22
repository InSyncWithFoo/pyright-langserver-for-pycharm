package com.insyncwithfoo.pyrightls.configuration.project

import com.insyncwithfoo.pyrightls.configuration.common.PyrightLSConfigurable
import com.insyncwithfoo.pyrightls.message
import com.intellij.openapi.project.Project
import com.intellij.util.xmlb.XmlSerializerUtil


internal class PyrightLSProjectConfigurable internal constructor(project: Project) :
    PyrightLSConfigurable<Configurations>() {
    
    override val service = ConfigurationService.getInstance(project)
    override val panel by lazy { ConfigurationPanel(project) }
    
    override val originalConfigurations: Configurations =
        XmlSerializerUtil.createCopy(service.configurations)
    
    override fun getDisplayName() = message("configurations.project.displayName")
    
}
