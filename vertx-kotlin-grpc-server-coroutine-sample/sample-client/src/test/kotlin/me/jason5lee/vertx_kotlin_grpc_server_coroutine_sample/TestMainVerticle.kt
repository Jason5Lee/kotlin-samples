package me.jason5lee.vertx_kotlin_grpc_server_coroutine_sample

import io.vertx.core.Vertx
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import me.jason5lee.vertx_kotlin_grpc_server_coroutine_sample.MainVerticle

@ExtendWith(VertxExtension::class)
class TestMainVerticle {

    @BeforeEach
    fun deployVerticle(vertx: Vertx, testContext: VertxTestContext) {
        vertx.deployVerticle(MainVerticle(), testContext.succeeding<String> { _ -> testContext.completeNow() })
    }

    @Test
    fun verticleDeployed(vertx: Vertx, testContext: VertxTestContext) {
        testContext.completeNow()
    }
}
