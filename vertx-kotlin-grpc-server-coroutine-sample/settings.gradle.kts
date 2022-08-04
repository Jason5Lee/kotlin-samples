rootProject.name = "vertx-kotlin-grpc-server-coroutine-sample"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}

include("sample-stub", "sample-protos", "sample-client", "sample-server")
