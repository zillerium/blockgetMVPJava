package com.blockget.grpc.server;

import com.proto.example.AuditMessage;
import com.proto.example.AuditResponse;
import com.proto.example.AuditServiceGrpc;
import io.grpc.stub.StreamObserver;

public class AuditServiceImpl  extends AuditServiceGrpc.AuditServiceImplBase {

    @Override
    public void audit(AuditMessage request, StreamObserver<AuditResponse> responseObserver) {
        String hashcode = request.getHashcode();
        String account = request.getAccount();

        String result = "this is a server response from Blockget";
        AuditResponse ar = AuditResponse.newBuilder().setResult(result).build();

        responseObserver.onNext(ar);

        responseObserver.onCompleted();

       // super.audit(request, responseObserver);
    }
}
