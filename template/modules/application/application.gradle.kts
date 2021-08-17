plugins {
	id("project.base")
	id("project.testing")
	application
}

application.mainClass.set("{{basePackage}}.MainKt")
