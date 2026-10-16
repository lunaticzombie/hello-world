# Hello World Android App

This repository contains a minimal native Android app.
The app asks the user for their name and shows a personalized greeting.
If the user taps **Say hello** without entering a name, the input shows a clear validation error and the placeholder greeting remains visible.

## Project structure

- `app/src/main/java/com/example/helloworld/MainActivity.java` contains the app behavior.
- `app/src/main/res/layout/activity_main.xml` contains the single-screen UI.
- `app/src/main/res/values/` contains app strings, colors, and theme resources.
- `scripts/validate-local.sh` performs static validation that can run without the Android SDK.

## Build and run with Android tooling

Install Android Studio or the Android SDK plus Gradle.
Open the project root in Android Studio, let it sync the Gradle project, and run the `app` configuration on an emulator or device.
From a machine with Gradle and the Android SDK installed, you can also run:

```sh
gradle :app:assembleDebug
```

The generated debug APK will be under `app/build/outputs/apk/debug/`.

## Local validation in this environment

This environment has Gradle 8.10.2 and Android SDK API 35 installed.
The Android debug build was verified successfully with `gradle :app:assembleDebug`.
The repository also includes a local static validation script that checks the expected Android project files and the core greeting behavior markers:

```sh
./scripts/validate-local.sh
```

Run the Gradle build again after making changes before distributing the APK.
