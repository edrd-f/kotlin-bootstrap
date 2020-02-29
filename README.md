# Kotlin Bootstrap

![](https://github.com/edrd-f/kotlin-bootstrap/workflows/build/badge.svg?branch=master)

This repository contains a basic Gradle setup for Kotlin projects using the language's conventions, such as indentation and directory structure.

It also includes Gradle configurations and tips for faster build/test runs (details below).

## Using it

Simply execute the command below (requires curl and bash): 

```sh
bash <(curl -sSL https://raw.githubusercontent.com/edrd-f/kotlin-bootstrap/master/script/bootstrap)
```

## Using OpenJ9 to speed up build and tests

1. Install [OpenJ9](https://adoptopenjdk.net/releases.html?jvmVariant=openj9) by extracting it to a directory such as `/opt/jdk/openj9/0.18.1`
1. Add the following to your `/etc/environment`, replacing `<YOUR-USER-HOME>`:
    ```sh
    JAVA_HOME=/opt/jdk/openj9/0.18.1
    OPENJ9_JAVA_OPTIONS="-Xquickstart -Xms64m -Xscmx128m -XX:TieredStopAtLevel=1 -Xshareclasses -Xshareclasses:cacheDir=<YOUR-USER-HOME>/.javasharedresources"
    ```
1. Restart your OS to apply the environment changes

Running `java -version` should display something like "Eclipse OpenJ9 VM AdoptOpenJDK (build ...)".

## Configuring OpenJ9 on IntelliJ

* Under `File > Project Settings > Platform Settings > SDKs` add a new SDK, selecting the OpenJ9 directory
* Under `File > Project Settings > Project`, set "Project SDK" to OpenJ9
* Under `Settings > Build, Execution, Deployment > Gradle`, set "Build and run using" and "Run tests using" to "Gradle", and make sure Gradle JVM is set to OpenJ9
* Under `Settings > Build, Execution, Deployment > Compiler`, check "Build project automatically" and "Compile independent modules in parallel" (optional)
