@file:Suppress("unused", "className")
package libraries

abstract class LibrariesExtension : BaseDependencyManagement() {
  val junitApi = dep("org.junit.jupiter", "junit-jupiter-api", versions.junit)
  val junitEngine = dep("org.junit.jupiter", "junit-jupiter-engine", versions.junit)

	private object versions {
  	const val junit = "5.7.0"
  }
}
