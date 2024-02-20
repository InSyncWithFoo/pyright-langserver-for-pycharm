<!-- Plugin description -->
# [Pyright][1] for PyCharm...

...Professional Edition, using [the experimental LSP API][2] added in 2023.2.
<!-- Plugin description end -->


## Known problems

This plugin doesn't work. Or at least not yet.
There are still quite a few problems to be taken care of.

### `pyright-langserver` just... doesn't work

Somehow Pyright doesn't respond to any requests.
It remains silent except during initialization and termination.
Here's an excerpt from the log (`idea.log`):

```text
2024-02-20 06:58:52,838 [  23580]   INFO - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;0): Starting server
2024-02-20 06:58:53,097 [  23839]   INFO - #c.i.p.l.a.LspServerDescriptor - PyrightLspServerDescriptor@test: starting LSP server: <Redacted>\test\venv\Scripts\pyright-langserver.exe [--stdio]
2024-02-20 06:58:57,303 [  28045]   INFO - #c.i.p.l.i.c.LspServerProcessListener - LSP server process started: <Redacted>\test\venv\Scripts\pyright-langserver.exe --stdio
2024-02-20 06:58:57,309 [  28051]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - PyrightLspServerDescriptor@test: LSP Listener thread started
2024-02-20 06:58:57,396 [  28138]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - PyrightLspServerDescriptor@test: initializing LSP server
2024-02-20 06:58:57,400 [  28142]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - <-- PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"window/logMessage","params":{"type":3,"message":"Pyright language server 1.1.351 starting"}}
2024-02-20 06:58:57,599 [  28341]   INFO - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;0): Pyright language server 1.1.351 starting
2024-02-20 06:58:57,694 [  28436]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - <-- PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"window/logMessage","params":{"type":3,"message":"Server root directory: file:///<Redacted>/.cache/pyright-python/1.1.351/node_modules/pyright/dist"}}
2024-02-20 06:58:57,694 [  28436]   INFO - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;0): Server root directory: file:///<Redacted>/.cache/pyright-python/1.1.351/node_modules/pyright/dist
2024-02-20 06:58:58,673 [  29415]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":"1","method":"initialize","params":{"processId":null,"rootPath":"<Redacted>/test","rootUri":"file:///<Redacted>/test","capabilities":{"workspace":{"workspaceEdit":{"documentChanges":true,"failureHandling":"abort"},"didChangeWatchedFiles":{"relativePatternSupport":true,"dynamicRegistration":true},"workspaceFolders":true},"textDocument":{"completion":{"completionItem":{"snippetSupport":true,"documentationFormat":["markdown","plaintext"],"deprecatedSupport":true,"tagSupport":{"valueSet":[1]},"insertReplaceSupport":true,"resolveSupport":{"properties":["documentation"]},"labelDetailsSupport":true},"completionList":{"itemDefaults":["commitCharacters","editRange","insertTextFormat","insertTextMode","data"]}},"hover":{"contentFormat":["markdown","plaintext"]},"formatting":{"dynamicRegistration":true},"definition":{"linkSupport":true},"codeAction":{"codeActionLiteralSupport":{"codeActionKind":{"valueSet":["quickfix","","source","refactor"]}},"disabledSupport":true},"publishDiagnostics":{"tagSupport":{"valueSet":[1,2]},"versionSupport":true}},"window":{"showMessage":{}},"general":{"staleRequestSupport":{"cancel":true,"retryOnContentModified":[]}}},"clientInfo":{"name":"PyCharm Professional Edition","version":"233.13763.11"},"workspaceFolders":[{"uri":"file:///<Redacted>/test","name":"test-pyright-3"}]}}
2024-02-20 06:58:58,715 [  29457]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - <-- PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"window/logMessage","params":{"type":3,"message":"Starting service instance \"test-pyright-3\""}}
2024-02-20 06:58:58,716 [  29458]   INFO - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;0): Starting service instance "test-pyright-3"
2024-02-20 06:58:58,717 [  29459]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - <-- PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":"1","result":{"capabilities":{"textDocumentSync":2,"definitionProvider":{"workDoneProgress":true},"declarationProvider":{"workDoneProgress":true},"typeDefinitionProvider":{"workDoneProgress":true},"referencesProvider":{"workDoneProgress":true},"documentSymbolProvider":{"workDoneProgress":true},"workspaceSymbolProvider":{"workDoneProgress":true},"hoverProvider":{"workDoneProgress":true},"documentHighlightProvider":{"workDoneProgress":true},"renameProvider":{"prepareProvider":true,"workDoneProgress":true},"completionProvider":{"triggerCharacters":[".","[","\"","'"],"resolveProvider":true,"workDoneProgress":true,"completionItem":{"labelDetailsSupport":true}},"signatureHelpProvider":{"triggerCharacters":["(",",",")"],"workDoneProgress":true},"codeActionProvider":{"codeActionKinds":["quickfix","source.organizeImports"],"workDoneProgress":true},"executeCommandProvider":{"commands":[],"workDoneProgress":true},"callHierarchyProvider":true,"workspace":{"workspaceFolders":{"supported":true,"changeNotifications":true}}}}}
2024-02-20 06:58:59,033 [  29775]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"initialized","params":{}}
2024-02-20 06:58:59,039 [  29781]   INFO - #c.i.p.l.i.c.Lsp4jServerConnector - PyrightLspServerDescriptor@test: server initialized
2024-02-20 06:58:59,058 [  29800]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - <-- PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":0,"method":"client/registerCapability","params":{"registrations":[{"id":"c5556121-a93e-42ef-9c64-6a688ff3a2ed","method":"workspace/didChangeWatchedFiles","registerOptions":{"watchers":[{"globPattern":"**/pyrightconfig.json","kind":7},{"globPattern":"**","kind":7}]}}]}}
2024-02-20 06:58:59,081 [  29823]   FINE - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;0): Opening files after server initialization or after move/rename: [file://<Redacted>/test/src/pkg/__init__.py]
2024-02-20 06:58:59,085 [  29827]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"textDocument/didOpen","params":{"textDocument":{"uri":"file:///<Redacted>/test/src/pkg/__init__.py","languageId":"python","version":0,"text":"import re\nfrom typing import TypeVarTuple, Unpack\n\nTs \u003d TypeVarTuple(\u0027Ts\u0027)\n\n\ndef f(*args: Unpack[Ts]) -\u003e tuple[Unpack[Ts]]:\n    a \u003d args\n    return args\n\n\nreveal_type(f)\n\nfoo: int \u003d \u0027bar\u0027\n\nbaz \u003d re.match(\u0027q .*ux\u0027, \u0027lorem ipsum\u0027)\nb \u003d baz.group()\n\nlorem: str | None \u003d \u0027ipsum\u0027\nlorem.upper()\n\n"}}}
2024-02-20 06:58:59,398 [  30140]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":0,"result":null}
2024-02-20 06:59:01,853 [  32595]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"workspace/didChangeWatchedFiles","params":{"changes":[{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright-1.1.330.dist-info","type":3},{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright/cli.py","type":2},{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright/node.py","type":2},{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright/py.typed","type":2},{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright/types.py","type":2},{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright/utils.py","type":2},{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright/_mureq.py","type":2},{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright/_utils.py","type":2},{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright/errors.py","type":2},{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright/__init__.py","type":2},{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright/__main__.py","type":2},{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright/_version.py","type":2},{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright/langserver.py","type":2},{"uri":"file:///<Redacted>/test/venv/Lib/site-packages/pyright-1.1.351.dist-info","type":1},{"uri":"file:///<Redacted>/test/venv/Scripts/pyright.exe","type":2},{"uri":"file:///<Redacted>/test/venv/Scripts/pyright-python.exe","type":2},{"uri":"file:///<Redacted>/test/venv/Scripts/pyright-langserver.exe","type":2},{"uri":"file:///<Redacted>/test/venv/Scripts/pyright-python-langserver.exe","type":2}]}}
2024-02-20 06:59:18,044 [  48786]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":"2","method":"textDocument/codeAction","params":{"textDocument":{"uri":"file:///<Redacted>/test/src/pkg/__init__.py"},"range":{"start":{"line":21,"character":0},"end":{"line":21,"character":0}},"context":{"diagnostics":[],"triggerKind":2}}}
2024-02-20 06:59:27,966 [  58708]   INFO - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;1): No response from the server in 10000ms for: textDocument/codeAction
2024-02-20 06:59:27,967 [  58709]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"$/cancelRequest","params":{"id":"2"}}
2024-02-20 07:00:29,941 [ 120683]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":"3","method":"textDocument/hover","params":{"textDocument":{"uri":"file:///<Redacted>/test/src/pkg/__init__.py"},"position":{"line":3,"character":1}}}
2024-02-20 07:00:30,247 [ 120989]   INFO - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;1): No response from the server in 300ms for: textDocument/hover
2024-02-20 07:00:30,247 [ 120989]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"$/cancelRequest","params":{"id":"3"}}
2024-02-20 07:00:33,483 [ 124225]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":"4","method":"textDocument/hover","params":{"textDocument":{"uri":"file:///<Redacted>/test/src/pkg/__init__.py"},"position":{"line":11,"character":12}}}
2024-02-20 07:00:33,785 [ 124527]   INFO - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;1): No response from the server in 300ms for: textDocument/hover
2024-02-20 07:00:33,786 [ 124528]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"$/cancelRequest","params":{"id":"4"}}
2024-02-20 07:00:37,473 [ 128215]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":"5","method":"textDocument/hover","params":{"textDocument":{"uri":"file:///<Redacted>/test/src/pkg/__init__.py"},"position":{"line":8,"character":13}}}
2024-02-20 07:00:37,778 [ 128520]   INFO - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;1): No response from the server in 300ms for: textDocument/hover
2024-02-20 07:00:37,778 [ 128520]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"$/cancelRequest","params":{"id":"5"}}
2024-02-20 07:00:42,598 [ 133340]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":"6","method":"textDocument/hover","params":{"textDocument":{"uri":"file:///<Redacted>/test/src/pkg/__init__.py"},"position":{"line":13,"character":2}}}
2024-02-20 07:00:42,904 [ 133646]   INFO - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;1): No response from the server in 300ms for: textDocument/hover
2024-02-20 07:00:42,905 [ 133647]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"$/cancelRequest","params":{"id":"6"}}
2024-02-20 07:00:45,401 [ 136143]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":"7","method":"textDocument/hover","params":{"textDocument":{"uri":"file:///<Redacted>/test/src/pkg/__init__.py"},"position":{"line":15,"character":11}}}
2024-02-20 07:00:45,708 [ 136450]   INFO - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;1): No response from the server in 300ms for: textDocument/hover
2024-02-20 07:00:45,708 [ 136450]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"$/cancelRequest","params":{"id":"7"}}
2024-02-20 07:00:50,439 [ 141181]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":"8","method":"textDocument/completion","params":{"context":{"triggerKind":1},"textDocument":{"uri":"file:///<Redacted>/test/src/pkg/__init__.py"},"position":{"line":21,"character":0}}}
2024-02-20 07:00:59,063 [ 149805]   WARN - #c.i.e.p.BaseOSProcessHandler - Process hasn't generated any output for a long time.
If it's a long-running mostly idle daemon process, consider overriding OSProcessHandler#readerOptions with 'BaseOutputReader.Options.forMostlySilentProcess()' to reduce CPU usage.
Command line: <Redacted>\test\venv\Scripts\pyright-langserver.exe --stdio
java.lang.Throwable: Process creation:
	at com.intellij.execution.process.BaseOSProcessHandler.<init>(BaseOSProcessHandler.java:32)
	at com.intellij.execution.process.OSProcessHandler.<init>(OSProcessHandler.java:44)
	at com.intellij.platform.lsp.api.LspServerDescriptor.startServerProcess(LspServerDescriptor.kt:95)
	at com.intellij.platform.lsp.impl.connector.Lsp4jServerConnectorStdio.<init>(Lsp4jServerConnectorStdio.java:19)
	at com.intellij.platform.lsp.impl.LspServerImpl.J(LspServerImpl.java:383)
	at com.intellij.openapi.application.impl.ApplicationImpl$2.run(ApplicationImpl.java:249)
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:539)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
	at java.base/java.util.concurrent.Executors$PrivilegedThreadFactory$1$1.run(Executors.java:702)
	at java.base/java.util.concurrent.Executors$PrivilegedThreadFactory$1$1.run(Executors.java:699)
	at java.base/java.security.AccessController.doPrivileged(AccessController.java:399)
	at java.base/java.util.concurrent.Executors$PrivilegedThreadFactory$1.run(Executors.java:699)
	at java.base/java.lang.Thread.run(Thread.java:840)
2024-02-20 07:01:00,439 [ 151181]   INFO - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;1): No response from the server in 10000ms for: textDocument/completion
2024-02-20 07:01:00,439 [ 151181]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"$/cancelRequest","params":{"id":"8"}}
2024-02-20 07:01:09,495 [ 160237]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"workspace/didChangeWatchedFiles","params":{"changes":[{"uri":"file:///<Redacted>/test/.idea/workspace.xml","type":2}]}}
2024-02-20 07:01:10,844 [ 161586]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"textDocument/didClose","params":{"textDocument":{"uri":"file:///<Redacted>/test/src/pkg/__init__.py"}}}
2024-02-20 07:01:10,983 [ 161725]   FINE - #c.i.p.l.i.LspServerManagerImpl - PyrightLspServerDescriptor@test(RUNNING;0): got stop server request
2024-02-20 07:01:10,983 [ 161725]   FINE - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(STOPPED;0): Stopping server
2024-02-20 07:01:10,987 [ 161729]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":"9","method":"shutdown","params":null}
2024-02-20 07:01:11,726 [ 162468]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - <-- PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"window/logMessage","params":{"type":3,"message":"Starting service instance \"<default>\""}}
2024-02-20 07:01:11,728 [ 162470]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - <-- PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":"9","result":null}
2024-02-20 07:01:11,733 [ 162475]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - <-- PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"window/logMessage","params":{"type":3,"message":"No source files found."}}
2024-02-20 07:01:11,733 [ 162475]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - <-- PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","id":"8","result":null}
2024-02-20 07:01:11,741 [ 162483]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - --> PyrightLspServerDescriptor@test: {"jsonrpc":"2.0","method":"exit","params":null}
2024-02-20 07:01:11,742 [ 162484]   FINE - #c.i.p.l.i.c.Lsp4jServerConnector - Stopping process: <Redacted>\test\venv\Scripts\pyright-langserver.exe --stdio
```

As you can <em>clearly</em> see, PyCharm is complaining, multiple times,
that it didn't receive a response:

```text
2024-02-20 06:59:27,966 [  58708]   INFO - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;1): No response from the server in 10000ms for: textDocument/codeAction
2024-02-20 07:00:30,247 [ 120989]   INFO - #c.i.p.l.i.LspServerImpl - PyrightLspServerDescriptor@test(RUNNING;1): No response from the server in 300ms for: textDocument/hover
```

The reason? No idea.


### Tests and documentation

As stated, this plugin doesn't even work, and I don't know why.
That said, there is no point in documenting it at this time.
TDD is not applicable, because I also don't know for sure what to expect.


## Debugging

* Clone this repository, then open the directory using IntelliJ.
* Run the "*Run Plugin*" run configuration.
  This will build the plugin from scratch. It may take a while.
* When PyCharm is fully started, open an arbitrary Python project.
* Open *Settings*, then open the *Pyright* panel in the *Tools* section.
* Pick an executable (typically named `pyright-langserver`
  or `pyright-python-langserver`).
* Click *OK*. Observe that a new `pyright-experimental.xml` file
  is created in the `.idea` subdirectory of the Python project.
* Try hovering over variables to see that nothing happens.
* Try pressing <kbd>Ctrl</kbd> + <kbd>Space</kbd> or the corresponding
  shortcut for your system and observe a spinner at the bottom of the drop menu.
  It persists for about 10 seconds before disappearing.
* Close PyCharm. Open the `idea.log` file at
  `/build/idea-sandbox/system/log/idea.log` and search for lines containing
  `LspServerImpl` or `Lsp4jServerConnector`.
* Compare that with the traceback excerpt above.

## Credits

Most of the code is derived from [@koxudaxi/ruff-pycharm-plugin][3].
It is such a fortune that that plugin does almost the same thing
and is also written in Kotlin, and hence easily understandable.

The SVG logo is derived from [the README image][4] of the [@microsoft/pyright][1]
repository, generated using Inkscape's autotrace feature.


  [1]: https://github.com/microsoft/pyright
  [2]: https://plugins.jetbrains.com/docs/intellij/language-server-protocol.html
  [3]: https://github.com/koxudaxi/ruff-pycharm-plugin
  [4]: https://github.com/microsoft/pyright/blob/main/docs/img/PyrightLarge.png
