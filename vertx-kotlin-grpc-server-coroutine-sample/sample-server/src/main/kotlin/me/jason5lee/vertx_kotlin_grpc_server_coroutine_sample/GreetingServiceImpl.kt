package me.jason5lee.vertx_kotlin_grpc_server_coroutine_sample

class GreetingServiceImpl : GreetingServiceGrpcKt.GreetingServiceCoroutineImplBase() {
    override suspend fun greet(request: GreetRequest): GreetResponse =
        GreetResponse.newBuilder()
            .setMessage("Hello, ${request.name}")
            .build()
}