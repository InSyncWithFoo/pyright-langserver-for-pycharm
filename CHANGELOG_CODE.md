<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Code changelog


This page documents code changes.
For user-facing changes, see [`CHANGELOG.md`][_-1].


  [_-1]: ./CHANGELOG.md


## [Unreleased]

### Changed

* The [`build.yaml`][5-1] workflow now:
  * Edits old releases when the changelogs are changed, and
  * Upload corresponding artifacts as new drafts are created.
  
  The two helper Python scripts are added under [`.scripts`][5-2]. (HEAD)

* Plugin verifier results are now always uploaded. (HEAD)

[5-1]: https://github.com/InSyncWithFoo/pyright-langserver-for-pycharm/blob/master/.github/workflows/build.yaml
[5-2]: https://github.com/InSyncWithFoo/pyright-langserver-for-pycharm/blob/master/.scripts/


## [0.1.0-poc.2] - 2024-03-24

### Added

* Project option "Auto-suggest executable" is added. (6dffdaa6)
* [Icons][2-1] are added. (6dffdaa6)
* Messages are merged into one single bundle. (6dffdaa6)
* The "Always use global" option is moved to
  the second column of the second row. (6dffdaa6)
* `PyrightLSAllConfigurations` is added. (6dffdaa6)

### Changed

* Project is renamed. (f821150f)
* Configuration constructs are now marked internal. (6dffdaa6)
* [`CHANGELOG.md`][2-2] is rewritten and
  `CHANGELOG_CODE.md` is added. (6dffdaa6)
* Gradle is updated to 8.7. (4ad34a46)


  [2-1]: https://github.com/InSyncWithFoo/pyright-langserver-for-pycharm/tree/master/src/main/resources/icons
  [2-2]: https://github.com/InSyncWithFoo/pyright-langserver-for-pycharm/tree/master/CHANGELOG.md


## [0.1.0-poc.1] - 2024-03-17

### Added

* Project initialized.


  [Unreleased]: https://github.com/InSyncWithFoo/pyright-for-pycharm/compare/v0.1.0-poc.2..HEAD
  [0.1.0-poc.2]: https://github.com/InSyncWithFoo/pyright-for-pycharm/compare/v0.1.0-poc.1..v0.1.0-poc.2
  [0.1.0-poc.1]: https://github.com/InSyncWithFoo/pyright-langserver-for-pycharm/commits
