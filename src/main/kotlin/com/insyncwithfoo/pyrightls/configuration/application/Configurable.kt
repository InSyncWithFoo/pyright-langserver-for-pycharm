package com.insyncwithfoo.pyrightls.configuration.application

import com.insyncwithfoo.pyrightls.configuration.common.PyrightLSConfigurable
import com.intellij.util.xmlb.XmlSerializerUtil


class PyrightLSApplicationConfigurable : PyrightLSConfigurable<Configurations>() {
    
    override val service = ConfigurationService.getInstance()
    override val panel by lazy { ConfigurationPanel() }
    
    override val originalConfigurations: Configurations =
        XmlSerializerUtil.createCopy(service.configurations)
    
    override fun getDisplayName() = DISPLAY_NAME
    
    companion object {
        const val DISPLAY_NAME = "Pyright LS (Global)"
    }
    
}
