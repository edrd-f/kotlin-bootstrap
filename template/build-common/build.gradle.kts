plugins {
	`kotlin-dsl`
}

repositories {
	mavenCentral()
}

dependencies {
	// Necessary for edrd.build-common.kotlin plugin
	implementation(kotlin("gradle-plugin"))
}

kotlinDslPluginOptions {
	experimentalWarning.set(false)
}
