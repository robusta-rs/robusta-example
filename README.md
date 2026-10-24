# Robusta examples

Runnable Java 17 projects showing how to use [Robusta](https://github.com/robusta-rs/robusta)
for formatting and linting.

| Project | Build configuration | Status |
| --- | --- | --- |
| [`gradle-kotlin`](gradle-kotlin/) | Gradle with Kotlin DSL | Ready |
| [`gradle-groovy`](gradle-groovy/) | Gradle with Groovy DSL | Ready |
| [`maven`](maven/) | Maven | Planned |

Each Gradle directory is a self-contained project with its own wrapper, build files, Java source,
and `robusta.yaml` configuration.

## Try an example

Choose either Gradle project and run it from its own directory:

```shell
cd gradle-kotlin
./gradlew run
./gradlew robustaCheck
```

Use `gradle-groovy` instead to try the Groovy DSL. The application prints `Hello, world!`, and
`robustaCheck` verifies its formatting and configured lint rules. Run `./gradlew robustaCheckFix`
to apply formatting and safe lint fixes.

The Robusta integration is intentionally small. Its relevant files are:

- `build.gradle.kts` or `build.gradle`, which applies the `rs.robusta` plugin.
- `robusta.yaml`, which configures formatting and lint rules.
- `src/main/java/com/example/App.java`, which provides source for Robusta to check.

## Test against a local Robusta checkout

Until version `0.1.0` is published, point an example at a Robusta source checkout and locally
built executable:

```shell
ROBUSTA_SOURCE=/absolute/path/to/robusta

cd gradle-kotlin
./gradlew \
  "-ProbustaPluginBuild=$ROBUSTA_SOURCE/apps/gradle-plugin" \
  "-ProbustaExecutable=$ROBUSTA_SOURCE/target/debug/robusta" \
  robustaCheck
```

The same command works from `gradle-groovy`.
