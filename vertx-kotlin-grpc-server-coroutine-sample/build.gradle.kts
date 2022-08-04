plugins {
    id("com.google.protobuf") version Versions.protobufPlugin apply false
    kotlin("jvm") version Versions.kotlin apply false
    id("com.github.johnrengelman.shadow") version Versions.shadow apply false
}

group = "me.jason5lee"
version = "1.0.0-SNAPSHOT"

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
}
