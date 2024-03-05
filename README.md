<!-- Plugin description -->
# Pyright Language Server for PyCharm Professional

This plugin uses [the experimental LSP API][1] added in 2023.2
to integrate [Pyright][2]'s capabilities into PyCharm Professional.


  [1]: https://plugins.jetbrains.com/docs/intellij/language-server-protocol.html
  [2]: https://github.com/microsoft/pyright
<!-- Plugin description end -->

This is a proof of concept. It may or may not work.
See existing issues for more information on the progress.


## Installation

ZIP artifacts [are generated][3] for every push/PR by GitHub Actions.
Download them and follow the instructions described [here][4].


## Credits

Most of the code is derived from [@koxudaxi/ruff-pycharm-plugin][5].
It is such a fortune that that plugin does almost the same thing
and is also written in Kotlin, and hence easily understandable.

The SVG and PNG logos are derived from [the README image][6]
of the [@microsoft/pyright][2] repository,
generated using Inkscape's autotrace feature.


## See also

* [Pyright for PyCharm][7], its sister plugin for PyCharm Community
  that makes use of Pyright's CLI interface.


  [3]: https://github.com/InSyncWithFoo/pyright-experimental-plugin/actions/workflows/build.yaml
  [4]: https://www.jetbrains.com/help/pycharm/managing-plugins.html#install_plugin_from_disk
  [5]: https://github.com/koxudaxi/ruff-pycharm-plugin
  [6]: https://github.com/microsoft/pyright/blob/main/docs/img/PyrightLarge.png
  [7]: https://github.com/InSyncWithFoo/pyright-plugin
