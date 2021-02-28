package libraries

abstract class BaseDependencyManagement {
  protected fun dep(group: String, artifact: String, version: String) = "$group:$artifact:$version"
}
