# Using OpenJ9 to speed up the build

1. Install [OpenJ9](https://adoptopenjdk.net/releases.html?jvmVariant=openj9) by extracting it to a directory such as `/opt/jdk/openj9/0.18.1`
1. Add the following to your `/etc/environment`, replacing `<YOUR-USER-HOME>`:
    ```sh
    JAVA_HOME=/opt/jdk/openj9/0.20.0
    OPENJ9_JAVA_OPTIONS="-Xquickstart -Xms64m -Xscmx128m -XX:TieredStopAtLevel=1 -Xshareclasses -Xshareclasses:cacheDir=<YOUR-USER-HOME>/.javasharedresources"
    ```
1. Alternatively, you can add the Java options to the `lib/options.default` file inside the OpenJ9 installation directory.
1. Restart your OS to apply the environment changes

Running `java -version` should display something like "Eclipse OpenJ9 VM AdoptOpenJDK (build ...)".

## Configuring OpenJ9 on IntelliJ

* Under `File > Project Settings > Platform Settings > SDKs` add a new SDK, selecting the OpenJ9 directory
* Under `File > Project Settings > Project`, set "Project SDK" to OpenJ9
* Under `Settings > Build, Execution, Deployment > Gradle`, set "Build and run using" and "Run tests using" to "Gradle", and make sure Gradle JVM is set to OpenJ9
* Under `Settings > Build, Execution, Deployment > Compiler`, check "Build project automatically" and "Compile independent modules in parallel" (optional)
