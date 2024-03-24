<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Changelog

This page documents user-facing changes.
For code changes, see [`CHANGELOG_CODE.md`][_-1].


  [_-1]: ./CHANGELOG_CODE.md


## [Unreleased]

<i>This section is currently empty.</i>


## [0.1.0-poc.2] - 2024-03-24

### Added

* The plugin will now suggest setting an executable
  for the current project if one can be found locally.
  To turn off suggestion for a project, uncheck
  the corresponding option in the project configuration panel.
  The notification group used is named "<i>Pyright LS notifications</i>".

### Changed

* The project is renamed from `pyright-experimental-plugin` to
  `pyright-langserver` and the marketplace name of the plugin is now
  "<i>Pyright Language Server</i>" instead of "<i>Pyright (Experimental)</i>".
* UI components and messages are slightly changed.


## [0.1.0-poc.1] - 2024-03-17

### Added

* Project initialized.


  [Unreleased]: https://github.com/InSyncWithFoo/pyright-for-pycharm/compare/v0.1.0-poc.2..HEAD
  [0.1.0-poc.2]: https://github.com/InSyncWithFoo/pyright-for-pycharm/compare/v0.1.0-poc.1..v0.1.0-poc.2
  [0.1.0-poc.1]: https://github.com/InSyncWithFoo/pyright-langserver-for-pycharm/commits
