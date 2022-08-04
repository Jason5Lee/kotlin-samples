import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.plugins
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    kotlin("jvm")
    id("com.google.protobuf")
}

dependencies {
    protobuf(project(":sample-protos"))

    api("io.grpc:grpc-stub:${Versions.grpc}")
    api("io.grpc:grpc-protobuf:${Versions.grpc}")
    api("io.grpc:grpc-kotlin-stub:${Versions.grpcKotlin}")
    api("com.google.protobuf:protobuf-kotlin:${Versions.protobuf}")
    api("com.google.protobuf:protobuf-java-util:${Versions.protobuf}")
}

// Makes IntelliJ IDEA happy.
sourceSets {
    val main by getting { }
    main.java.srcDirs("build/generated/source/proto/main/java")
    main.java.srcDirs("build/generated/source/proto/main/grpc")
    main.java.srcDirs("build/generated/source/proto/main/kotlin")
    main.java.srcDirs("build/generated/source/proto/main/grpckt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
        jvmTarget = "11"
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${Versions.protobuf}"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${Versions.grpc}"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:${Versions.grpcKotlin}:jdk7@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.builtins {
                id("kotlin")
            }
            it.plugins {
                id("grpc")
                id("grpckt")
            }
        }
    }
}