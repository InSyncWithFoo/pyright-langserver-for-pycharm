package com.insyncwithfoo.pyrightls

import com.intellij.openapi.project.Project
import com.intellij.platform.lsp.api.LspServerListener
import com.intellij.platform.lsp.api.LspServerManager
import org.eclipse.lsp4j.DidChangeConfigurationParams
import org.eclipse.lsp4j.InitializeResult


@Suppress("UnstableApiUsage")
class PyrightLSLspServerListener(val project: Project) : LspServerListener {
    override fun serverInitialized(params: InitializeResult) {
        // pyright waits for all workspace folders to be initialised before processing
        // codeAction requests, but it never actually finishes initialising the workspace folders
        // sent with the initialize request unless kickstarted with an (empty) didChangeConfiguration notification
        // see: https://github.com/microsoft/pyright/issues/6874
        val lspServerManager = LspServerManager.getInstance(project)
        lspServerManager.getServersForProvider(PyrightLSLspServerSupportProvider::class.java).forEach {
            @Suppress("DEPRECATION")
            it.lsp4jServer.workspaceService.didChangeConfiguration(DidChangeConfigurationParams())
        }
    }
}
