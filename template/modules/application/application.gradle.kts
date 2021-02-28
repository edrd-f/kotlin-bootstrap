plugins {
	application
	id("build-common.defaults")
}

dependencies {
	testImplementation(libs.junitApi)
	testRuntimeOnly(libs.junitEngine)
}

application.mainClass.set("{{basePackage}}.MainKt")
