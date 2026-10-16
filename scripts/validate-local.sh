#!/usr/bin/env bash
set -euo pipefail

required_files=(
  "settings.gradle"
  "build.gradle"
  "app/build.gradle"
  "app/src/main/AndroidManifest.xml"
  "app/src/main/java/com/example/helloworld/MainActivity.java"
  "app/src/main/res/layout/activity_main.xml"
  "app/src/main/res/values/strings.xml"
)

for file in "${required_files[@]}"; do
  [[ -f "$file" ]] || { echo "Missing $file" >&2; exit 1; }
done

grep -q "com.android.application" build.gradle app/build.gradle
grep -q "<EditText" app/src/main/res/layout/activity_main.xml
grep -q "@+id/nameInput" app/src/main/res/layout/activity_main.xml
grep -q "@+id/helloButton" app/src/main/res/layout/activity_main.xml
grep -q "@+id/greetingText" app/src/main/res/layout/activity_main.xml
grep -q "Hello, " app/src/main/java/com/example/helloworld/MainActivity.java
grep -q "setError" app/src/main/java/com/example/helloworld/MainActivity.java
grep -q "empty_name_error" app/src/main/res/values/strings.xml

echo "Local project structure validation passed."
