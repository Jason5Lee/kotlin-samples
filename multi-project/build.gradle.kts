plugins {
    kotlin("jvm") version Versions.kotlin apply false
}

group = "me.jason5lee"
version = "1.0.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}
