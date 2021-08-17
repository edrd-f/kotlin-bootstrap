plugins {
	kotlin("jvm")
}

dependencies {
  val junitVersion = "5.7.2"
	testCompileOnly("org.junit.jupiter:junit-jupiter-api:$junitVersion")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
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
