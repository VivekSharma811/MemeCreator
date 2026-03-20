# MemeCreator

Cross-platform meme editor built with **Kotlin Multiplatform** and **Compose Multiplatform**. Shared UI and logic run on **Android** and **iOS**; platform-specific pieces handle saving, sharing, and image export.

## Features

- **Gallery** — Browse meme templates and pick one to edit.
- **Editor** — Place and style text on the template, with draggable text boxes and export/share flows backed by expect/actual implementations per platform.

## Tech stack

| Area | Choices |
|------|---------|
| Language | Kotlin 2.2 |
| UI | Compose Multiplatform, Material 3 |
| Navigation | JetBrains Navigation for Compose (typed routes) |
| DI | Koin |
| Images | Coil 3 |
| Serialization | kotlinx.serialization |

Android targets **minSdk 24**, **compile/target SDK 36** (see `gradle/libs.versions.toml`). iOS deployment target is **17.0** in the Xcode project (`iosApp/iosApp.xcodeproj`).

## Requirements

- **JDK 17+** (typical for current Android Gradle Plugin)
- **Android Studio** (Koala+ recommended) or IntelliJ with KMP plugins
- **Xcode** with an **iOS 17+** simulator runtime (or device) for the iOS app
- **macOS** to build and run the iOS target

## Project layout

```
composeApp/          # KMP module: shared + androidMain + iosMain
iosApp/              # Xcode app shell; Swift entry loads Compose
  iosApp.xcodeproj   # Open this in Xcode
  Configuration/     # Config.xcconfig (bundle id, team placeholder)
```

- **`composeApp/src/commonMain`** — Screens, ViewModel, navigation, shared resources.
- **`composeApp/src/androidMain`** — `MainActivity`, Android exporters, FileProvider-style paths, etc.
- **`composeApp/src/iosMain`** — `MainViewController`, iOS exporters, cache paths, share sheet.

The iOS target builds a static **ComposeApp** framework via Gradle; Xcode runs the **Compile Kotlin Framework** script (`embedAndSignAppleFrameworkForXcode`) before compiling Swift.

## Run on Android

From the repo root:

```bash
./gradlew :composeApp:installDebug
```

Or use Android Studio: open the project root, select the **composeApp** run configuration, choose a device or emulator, then Run.

## Run on iOS

1. Optional: set your Apple team for signing. Edit `iosApp/Configuration/Config.xcconfig` and set `TEAM_ID` to your team suffix (or configure signing in Xcode). Simulators often work without a paid team; devices need a valid team.

2. Open **`iosApp/iosApp.xcodeproj`** in Xcode (not only the `iosApp` folder).

3. Select the **`iosApp`** scheme and an **iOS Simulator** (or device) whose OS is **≥ 17.0**.

4. Build & Run (**⌘R**). The first build may take a while while Gradle produces the framework.

If no simulators appear, install an iOS 17+ runtime under **Xcode → Settings → Platforms** and ensure the deployment target in Xcode is not higher than the runtimes you have installed.

## Useful Gradle tasks

| Task | Purpose |
|------|---------|
| `./gradlew :composeApp:assembleDebug` | Android debug APK |
| `./gradlew :composeApp:embedAndSignAppleFrameworkForXcode` | Framework for Xcode (normally invoked by the Xcode build phase) |

## Learn more

- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [Compose Multiplatform](https://www.jetbrains.com/compose-multiplatform/)

## License

Add a license file and reference it here if you publish the repo.
