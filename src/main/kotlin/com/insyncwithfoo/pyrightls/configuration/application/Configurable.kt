package com.insyncwithfoo.pyrightls.configuration.application

import com.insyncwithfoo.pyrightls.configuration.common.PyrightLSConfigurable
import com.insyncwithfoo.pyrightls.message
import com.intellij.util.xmlb.XmlSerializerUtil


internal class PyrightLSApplicationConfigurable : PyrightLSConfigurable<Configurations>() {
    
    override val service = ConfigurationService.getInstance()
    override val panel by lazy { ConfigurationPanel() }
    
    override val originalConfigurations: Configurations =
        XmlSerializerUtil.createCopy(service.configurations)
    
    override fun getDisplayName() = message("configurations.global.displayName")
    
}
