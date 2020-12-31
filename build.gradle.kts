import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.4.21"
	id("me.champeau.gradle.jmh") version "0.5.2"
}

group = "org.jire"
version = "0.1.0"

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
	jcenter()
}

dependencies {
	implementation("net.openhft", "chronicle-core", "2.20.126")
	
	val jmhVersion = "1.27"
	implementation("org.openjdk.jmh", "jmh-core", jmhVersion)
	annotationProcessor("org.openjdk.jmh", "jmh-generator-annprocess", jmhVersion)
	jmh("org.openjdk.jmh", "jmh-core", jmhVersion)
	jmhAnnotationProcessor("org.openjdk.jmh", "jmh-generator-annprocess", jmhVersion)
}

tasks.withType<KotlinCompile> {
	kotlinOptions.jvmTarget = "1.8"
}

jmh {
	duplicateClassesStrategy = DuplicatesStrategy.EXCLUDE
}