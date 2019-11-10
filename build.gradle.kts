import com.adarshr.gradle.testlogger.theme.ThemeType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    id("com.adarshr.test-logger") version("1.7.0")
    id("de.dplatz.clear") version("0.3")
    kotlin("jvm") version("1.3.50")
}

repositories {
    jcenter()
    maven("https://dl.bintray.com/spekframework/spek")
}

val spekVersion: String by project

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation(kotlin("test"))
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")

    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
}

kotlin {
    sourceSets["main"].kotlin.srcDir("src/main")
    sourceSets["main"].resources.srcDir("src/main/resources")
    sourceSets["test"].kotlin.srcDir("src/test")
    sourceSets["test"].resources.srcDir("src/test/resources")
}

application.mainClassName = "sample.project.Main"

testlogger {
    theme = ThemeType.MOCHA_PARALLEL
    showSimpleNames = true
}

tasks.withType<Test> {
    useJUnitPlatform {
        includeEngines("spek2")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

apply(from = "gradle/tests.gradle.kts")
