package com.kyrychenko.grpc.client;

import com.kyrychenko.grpc.HelloRequest;
import com.kyrychenko.grpc.HelloResponse;
import com.kyrychenko.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
        HelloResponse response = stub.hello(HelloRequest.newBuilder().setFirstName("Maks").setLastName("Kyrychenko").build());
        System.out.println(response.getGreeting());
        channel.shutdown();
    }
}
