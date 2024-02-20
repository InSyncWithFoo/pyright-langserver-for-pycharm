package com.insyncwithfoo.pyrightexperimental

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project
import com.intellij.util.xmlb.XmlSerializerUtil
import org.jetbrains.annotations.SystemDependent

@State(name = "PyrightConfigurations", storages = [Storage("pyright-experimental.xml")])
@Service(Service.Level.PROJECT)
class PyrightConfigurationService : PersistentStateComponent<PyrightConfigurationService> {

    var executable: @SystemDependent String? = null

    override fun getState() = this

    override fun loadState(service: PyrightConfigurationService) {
        XmlSerializerUtil.copyBean(service, this)
    }

    companion object {
        fun getInstance(project: Project): PyrightConfigurationService =
            project.getService(PyrightConfigurationService::class.java)
    }

}
