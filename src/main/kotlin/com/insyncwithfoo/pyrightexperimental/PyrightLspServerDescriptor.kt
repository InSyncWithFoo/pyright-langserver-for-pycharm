package com.insyncwithfoo.pyrightexperimental

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerListener
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor
import java.io.File

@Suppress("UnstableApiUsage")
class PyrightLspServerDescriptor(
    project: Project,
    private val executable: File
) : ProjectWideLspServerDescriptor(project, PRESENTABLE_NAME) {

    override fun isSupportedFile(file: VirtualFile) = file.extension == "py"

    override fun createCommandLine() = GeneralCommandLine(executable.absolutePath, "--stdio")

    override val lspServerListener = PyrightLspServerListener(project)

    companion object {
        const val PRESENTABLE_NAME = "Pyright"
    }

}
