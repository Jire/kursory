import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.4.21"
}

group = "org.jire"
version = "0.1.0"

repositories {
	jcenter()
}

dependencies {
	implementation("net.openhft:chronicle-core:2.20.126")
}

tasks.withType<KotlinCompile>() {
	kotlinOptions.jvmTarget = "1.8"
}