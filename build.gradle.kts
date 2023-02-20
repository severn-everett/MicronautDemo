import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.8.10"
    kotlin("jvm") version kotlinVersion
    //TODO Remove when upgrading Micronaut to 4.0
    kotlin("kapt") version kotlinVersion
    id("io.micronaut.application") version "3.7.2"
}

group = "com.severett"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

micronaut {
    version.set("3.8.5")
}

dependencies {
    //// Production
    // Implementation
    implementation("io.micronaut:micronaut-http-server-netty")
    implementation(kotlin("reflect"))
    //TODO Remove when upgrading Micronaut to 4.0
    kapt("io.micronaut:micronaut-inject-java")
    // Runtime-Only
    runtimeOnly("ch.qos.logback:logback-classic")
    //// Testing
    testImplementation(kotlin("test"))
}

tasks {
    withType<KotlinCompile> {
        compilerOptions {
            jvmTarget.set(JVM_17)
        }
    }
    test {
        useJUnitPlatform()
    }
}

kotlin {
    jvmToolchain(17)
}