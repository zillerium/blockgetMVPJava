package com.blockget.grpc.server;

import com.proto.example.AuditMessage;
import com.proto.example.AuditRequest;
import com.proto.example.AuditResponse;
import com.proto.example.AuditServiceGrpc;
import io.grpc.stub.StreamObserver;

public class AuditServiceImpl  extends AuditServiceGrpc.AuditServiceImplBase {

    @Override
    public void audit(AuditRequest request, StreamObserver<AuditResponse> responseObserver) {
        String hashcode = request.getMsg().getHashcode();
        String account = request.getMsg().getAccount();
System.out.println("hashcode " + hashcode);
        System.out.println("account " + account);
        String result = "this is a server response from Blockget " + hashcode;
        AuditResponse ar = AuditResponse.newBuilder().setResult(result).build();

        responseObserver.onNext(ar);

        responseObserver.onCompleted();
       // super.audit(request, responseObserver);
    }

//    public void audit(com.proto.example.AuditRequest request,
  //                    io.grpc.stub.StreamObserver<com.proto.example.AuditResponse> responseObserver) {
  //      asyncUnimplementedUnaryCall(getAuditMethod(), responseObserver);
  //  }

}
