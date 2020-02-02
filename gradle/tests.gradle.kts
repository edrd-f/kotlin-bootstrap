val isOpenJ9 = (
    System.getProperty("java.vm.name") == "Eclipse OpenJ9 VM" ||
    System.getProperty("java.vendor") == "Eclipse OpenJ9"
)

val openJ9Options = listOf(
    "-Xms64m",
    "-Xquickstart",
    "-Xshareclasses"
)

tasks.withType<Test> {
    reports {
        junitXml.isEnabled = false
        html.isEnabled = false
    }

    jvmArgs = mutableListOf("-noverify", "-XX:TieredStopAtLevel=1").apply {
        if (isOpenJ9) addAll(openJ9Options)
    }

    failFast = true

    maxParallelForks = Runtime.getRuntime().availableProcessors()
}
