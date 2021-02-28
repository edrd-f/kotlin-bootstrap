rootProject.name = "modules"

pluginManagement {
	@Suppress("UnstableApiUsage")
	plugins {
		kotlin("jvm").version("1.4.31")
	}
}

includeBuild("../build-common")

/**
 * Makes every children directory of this project a module. Also requires
 * that build files are named as <dirName>.gradle.kts. This improves file
 * search, otherwise searching for build.gradle.kts results in dozens of files.
 */
requireNotNull(rootDir.listFiles()) { "Unable to list files under $rootDir directory" }
	.asSequence()
	.filterNot { it.name in setOf(".gradle", "build") }
	.filter(File::isDirectory)
	.map(File::getName)
	.forEach { dir ->
		include(dir)
		project(":$dir").buildFileName = "$dir.gradle.kts"
	}
