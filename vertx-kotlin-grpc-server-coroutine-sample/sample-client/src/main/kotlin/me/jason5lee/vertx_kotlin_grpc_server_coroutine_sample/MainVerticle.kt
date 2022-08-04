package me.jason5lee.vertx_kotlin_grpc_server_coroutine_sample

import io.vertx.grpc.VertxChannelBuilder
import io.vertx.kotlin.coroutines.CoroutineVerticle

class MainVerticle : CoroutineVerticle() {
    override suspend fun start() {
        val channel = VertxChannelBuilder
            .forAddress(vertx, "localhost", 8080)
            .usePlaintext()
            .build()

        val stub = GreetingServiceGrpcKt.GreetingServiceCoroutineStub(channel)
        val name = "World"

        val resp = stub.greet(GreetRequest.newBuilder().setName(name).build())
        println(resp.message)
    }
}
