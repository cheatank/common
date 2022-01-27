plugins {
    kotlin("multiplatform") version "1.6.10"
    id("org.jmailen.kotlinter") version "3.8.0"
    id("com.github.ben-manes.versions") version "0.41.0"
    `maven-publish`
}

group = "com.github.cheatank"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
    }
    js(IR) {
        browser()
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib"))
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("reflect"))
            }
        }
    }
}
