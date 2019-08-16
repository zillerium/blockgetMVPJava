package com.blockget.grpc.client;


import com.proto.example.AuditMessage;
import com.proto.example.AuditRequest;
import com.proto.example.AuditResponse;
import com.proto.example.AuditServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class BlockgetClient {
    public static void main(String[] args) {
        System.out.println("client running");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",  50051).usePlaintext().build();

        AuditServiceGrpc.AuditServiceBlockingStub auditClient = AuditServiceGrpc.newBlockingStub(channel);

        String hashcode = "QmZfPNDiujH2KFuJhB47tAdup2ZY54611wiH6i15ZwTipa";
        String account = "trevor3";

        AuditMessage am = AuditMessage.newBuilder().setHashcode(hashcode).setAccount(account).build();

        AuditRequest auditRequest = AuditRequest.newBuilder().setMsg(am).build();

       AuditResponse resp =  auditClient.audit(am);
       System.out.println(resp.getResult());

       System.out.println("shutting client down");
       channel.shutdown();


    }

}
