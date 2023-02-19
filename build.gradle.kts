import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
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