# vertx-kotlin-grpc-server-coroutine-sample

A sample project of gRPC client and server, writting in Kotlin with coroutine, hosting with vert.x.

Put the protobuf files under `sample-protos/src/main/proto` directory.

Run `:sample-stub:generateProto` to generate the source code from protobuf.

Implement the client or server in `sample-client` or `sample-server` project.

Run `:sample-client:run` or `:sample-server:run` to run the gRPC client or server.
