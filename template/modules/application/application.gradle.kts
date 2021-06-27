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
	testImplementation(deps.junitApi)
	testRuntimeOnly(deps.junitEngine)
}
