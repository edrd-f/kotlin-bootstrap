plugins {
	application
	kotlin("jvm")
	id("project.unit-test")
}

repositories {
	mavenCentral()
}

application.mainClass.set("{{basePackage}}.MainKt")

dependencies {
	testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.7.2")
	testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine", "5.7.2")
}
