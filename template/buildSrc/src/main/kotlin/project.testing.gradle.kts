plugins {
	kotlin("jvm")
}

dependencies {
	testCompileOnly("org.junit.jupiter:junit-jupiter-api:${versions.junit}")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${versions.junit}")
}

tasks.withType<Test> {
	useJUnitPlatform {
		testLogging {
			events("passed", "skipped", "failed")
		}
	}

	reports {
		junitXml.required.set(false)
	}

	systemProperty("junit.jupiter.execution.parallel.enabled", "true")
	systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")

	maxParallelForks = Runtime.getRuntime().availableProcessors()
}
