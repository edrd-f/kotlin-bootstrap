rootProject.name = "{{projectName}}"

pluginManagement {
	val kotlinVersion: String by settings
	plugins {
		kotlin("jvm").version(kotlinVersion)
	}
}

/**
 * Makes every children directory of 'modules' a module. Also requires
 * that build files are named as <dirName>.gradle.kts. This improves file
 * search, otherwise searching for build.gradle.kts results in dozens of files.
 */
val modulesDir = rootDir.resolve("modules")
requireNotNull(modulesDir.listFiles()) { "Unable to list files under $modulesDir directory" }
	.asSequence()
	.filterNot { it.name in setOf(".gradle", "build") }
	.filter(File::isDirectory)
	.map(File::getName)
	.forEach { dir ->
		include(":$dir")
		project(":$dir").apply {
			projectDir = modulesDir.resolve(dir)	
			buildFileName = "$dir.gradle.kts"
		}
	}
