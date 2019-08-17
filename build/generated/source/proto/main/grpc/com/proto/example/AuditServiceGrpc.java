package com.proto.example;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: example/ExampleServices.proto")
public final class AuditServiceGrpc {

  private AuditServiceGrpc() {}

  public static final String SERVICE_NAME = "example.AuditService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.example.AuditRequest,
      com.proto.example.AuditResponse> getAuditMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Audit",
      requestType = com.proto.example.AuditRequest.class,
      responseType = com.proto.example.AuditResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.example.AuditRequest,
      com.proto.example.AuditResponse> getAuditMethod() {
    io.grpc.MethodDescriptor<com.proto.example.AuditRequest, com.proto.example.AuditResponse> getAuditMethod;
    if ((getAuditMethod = AuditServiceGrpc.getAuditMethod) == null) {
      synchronized (AuditServiceGrpc.class) {
        if ((getAuditMethod = AuditServiceGrpc.getAuditMethod) == null) {
          AuditServiceGrpc.getAuditMethod = getAuditMethod =
              io.grpc.MethodDescriptor.<com.proto.example.AuditRequest, com.proto.example.AuditResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Audit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.example.AuditRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.example.AuditResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuditServiceMethodDescriptorSupplier("Audit"))
              .build();
        }
      }
    }
    return getAuditMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuditServiceStub newStub(io.grpc.Channel channel) {
    return new AuditServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuditServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AuditServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuditServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AuditServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AuditServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void audit(com.proto.example.AuditRequest request,
        io.grpc.stub.StreamObserver<com.proto.example.AuditResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAuditMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAuditMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.example.AuditRequest,
                com.proto.example.AuditResponse>(
                  this, METHODID_AUDIT)))
          .build();
    }
  }

  /**
   */
  public static final class AuditServiceStub extends io.grpc.stub.AbstractStub<AuditServiceStub> {
    private AuditServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuditServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuditServiceStub(channel, callOptions);
    }

    /**
     */
    public void audit(com.proto.example.AuditRequest request,
        io.grpc.stub.StreamObserver<com.proto.example.AuditResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAuditMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuditServiceBlockingStub extends io.grpc.stub.AbstractStub<AuditServiceBlockingStub> {
    private AuditServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuditServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuditServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.example.AuditResponse audit(com.proto.example.AuditRequest request) {
      return blockingUnaryCall(
          getChannel(), getAuditMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuditServiceFutureStub extends io.grpc.stub.AbstractStub<AuditServiceFutureStub> {
    private AuditServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuditServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuditServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.example.AuditResponse> audit(
        com.proto.example.AuditRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAuditMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AUDIT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuditServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuditServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUDIT:
          serviceImpl.audit((com.proto.example.AuditRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.example.AuditResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AuditServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuditServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.example.ExampleServices.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuditService");
    }
  }

  private static final class AuditServiceFileDescriptorSupplier
      extends AuditServiceBaseDescriptorSupplier {
    AuditServiceFileDescriptorSupplier() {}
  }

  private static final class AuditServiceMethodDescriptorSupplier
      extends AuditServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuditServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AuditServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuditServiceFileDescriptorSupplier())
              .addMethod(getAuditMethod())
              .build();
        }
      }
    }
    return result;
  }
}
