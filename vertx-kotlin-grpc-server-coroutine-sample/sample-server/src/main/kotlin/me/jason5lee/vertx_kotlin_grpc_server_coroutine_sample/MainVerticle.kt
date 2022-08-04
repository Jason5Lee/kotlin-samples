package me.jason5lee.vertx_kotlin_grpc_server_coroutine_sample

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.grpc.VertxServerBuilder

class MainVerticle : AbstractVerticle() {

    override fun start(startPromise: Promise<Void>) {
        val rpcServer = VertxServerBuilder
            .forAddress(vertx, "localhost", 8080)
            .addService(GreetingServiceImpl())
            .build()
        rpcServer.start(startPromise)
    }
}
