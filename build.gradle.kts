import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version("1.3.50")
}

repositories {
    jcenter()
}

val junitVersion: String by project

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

kotlin {
    sourceSets["main"].kotlin.srcDir("src/main")
    sourceSets["main"].resources.srcDir("src/main/resources")
    sourceSets["test"].kotlin.srcDir("src/test")
    sourceSets["test"].resources.srcDir("src/test/resources")
}

application.mainClassName = "sample.project.Main"

tasks.withType<Test> {
    useJUnitPlatform {
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

apply(from = "gradle/tests.gradle.kts")
