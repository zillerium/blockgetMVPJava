package com.blockget.grpc.server;

import ch.decent.sdk.model.Account;
import ch.decent.sdk.model.NftData;
import ch.decent.sdk.model.NftModel;
import com.blockget.blockchain.BlockgetAccount;
import com.blockget.blockchain.BlockgetNftMgr;
import com.proto.example.AuditMessage;
import com.proto.example.AuditRequest;
import com.proto.example.AuditResponse;
import com.proto.example.AuditServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class AuditServiceImpl  extends AuditServiceGrpc.AuditServiceImplBase {

    @Override
    public void audit(AuditRequest request, StreamObserver<AuditResponse> responseObserver) {
        String hashcode = request.getMsg().getHashcode();
        String account = request.getMsg().getAccount();

        BlockgetNftMgr bnm = new BlockgetNftMgr();

        BlockgetAccount anAccount = new BlockgetAccount();
        Account myAcct = anAccount.getAccountByName(account);
        String accountName = account;
        List<NftData<? extends NftModel>> result=bnm.ConfirmNFT(myAcct);
        for (int i=0;i<result.size();i++) {
            NftModel c = result.get(i).getData();
            List<Object> d = c.values();
            String hashcodedata = (String) d.get(2);
            System.out.println("account - " + accountName + " file hash - " + hashcodedata);
        }

        bnm.issue("BGT", hashcode, account);


System.out.println("hashcode " + hashcode);
        System.out.println("account " + account);
        String result1 = "this is a server response from Blockget " + hashcode;
        AuditResponse ar = AuditResponse.newBuilder().setResult(result1).build();

        responseObserver.onNext(ar);

        responseObserver.onCompleted();
       // super.audit(request, responseObserver);
    }

//    public void audit(com.proto.example.AuditRequest request,
  //                    io.grpc.stub.StreamObserver<com.proto.example.AuditResponse> responseObserver) {
  //      asyncUnimplementedUnaryCall(getAuditMethod(), responseObserver);
  //  }

}
