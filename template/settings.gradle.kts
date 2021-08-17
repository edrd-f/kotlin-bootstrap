rootProject.name = "{{projectName}}"

pluginManagement {
	val kotlinVersion: String by settings
	plugins {
		kotlin("jvm") version kotlinVersion
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
		val moduleName = dir.replace(".", ":")
		include(":$moduleName")
		project(":$moduleName").apply {
			projectDir = modulesDir.resolve(dir)
			val lastModuleNameItem = dir.split(".").last()
			buildFileName = "$lastModuleNameItem.gradle.kts"
		}
	}
