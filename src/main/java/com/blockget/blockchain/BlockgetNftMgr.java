package com.blockget.blockchain;

import ch.decent.sdk.DCoreApi;
import ch.decent.sdk.crypto.Credentials;
import ch.decent.sdk.model.*;
import com.blockget.blockchain.BlockgetAccount;
import com.blockget.blockchain.BlockgetLogin;
import com.blockget.blockchain.BlockgetNft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlockgetNftMgr {

    private static final Long AMOUNT_OF_DCT_REQUIRED_FOR_NFT_ISSUE = 500000L;
    private static final Boolean TOKEN_IS_TRANSFERABLE = true;
    private static final Boolean MAX_SUPPLY_IS_FIXED = true;
    private static final Long MAX_NUMBER_OF_TOKENS = 1000L;

    @Autowired
    private BlockgetConnection connectionExample;
    @Autowired
    private BlockgetLogin loginExample;
    @Autowired
    private BlockgetAccount accountExample;

    /**
     * Issue the brand new non fungible token into circulation.
     *
     * @param symbol String version of the new NFT symbol.
     * @return Transaction confirmation.
     */
    public TransactionConfirmation create(String symbol) {

        connectionExample = new BlockgetConnection();
        loginExample = new BlockgetLogin();

        final DCoreApi dcoreApi = connectionExample.connect();
        final Credentials credentials = loginExample.login(connectionExample);
        final String description = "BGT Token";

        return dcoreApi.getNftApi()
                .create(
                        credentials,
                        symbol,
                        MAX_NUMBER_OF_TOKENS,
                        MAX_SUPPLY_IS_FIXED,
                        description,
                        BlockgetNft.class,
                        TOKEN_IS_TRANSFERABLE)
                .blockingGet();
    }

    /**
     * Issue the new created NFT to some accountName.
     *
     * @param symbol String version of the NFT symbol.
     * @return Transaction confirmation.
     */
    public TransactionConfirmation issue(String symbol, String cid, String account) {
        connectionExample = new BlockgetConnection();
        loginExample = new BlockgetLogin();
        final DCoreApi dcoreApi = connectionExample.connect();
        final Credentials credentials = loginExample.login(connectionExample);
        final AssetAmount dctAssetAmount = new AssetAmount(AMOUNT_OF_DCT_REQUIRED_FOR_NFT_ISSUE);
        final Fee initialFee = new Fee(dctAssetAmount.getAssetId(), AMOUNT_OF_DCT_REQUIRED_FOR_NFT_ISSUE);

        return dcoreApi.getNftApi()
                .issue(
                        credentials,
                        symbol,
                        credentials.getAccount(),
                        new BlockgetNft(5, false, cid),
                        null,
                        initialFee)
                .blockingGet();
    }

    /**
     * Send one non fungible token to some account on DCore block-chain.
     *
     * @param receiverAccountName account name of token receiver.
     * @return Transaction confirmation.
     */
    public TransactionConfirmation sendToken(String receiverAccountName) {
        connectionExample = new BlockgetConnection();
        loginExample = new BlockgetLogin();
        final DCoreApi dcoreApi = connectionExample.connect();
        final Credentials credentials = loginExample.login(connectionExample);
        final Account receiver = accountExample.getAccountByName(receiverAccountName);
        final List<NftData<? extends NftModel>> result = getNftByAccount(credentials.getAccount(), connectionExample);

        return dcoreApi.getNftApi()
                .transfer(
                        credentials,
                        receiver.getId(),
                        result.get(0).getId())
                .blockingGet();
    }

    public List<NftData<? extends NftModel>> ConfirmNFT(Account receiver) {
        connectionExample = new BlockgetConnection();
        loginExample = new BlockgetLogin();
        final DCoreApi dcoreApi = connectionExample.connect();
        final Credentials credentials = loginExample.login(connectionExample);
      //  final Account receiver = accountExample.getAccountByName(receiverAccountName);
        final List<NftData<? extends NftModel>> result = getNftByAccount(credentials.getAccount(), connectionExample);

       return result;
    }


    /**
     * Search for the NFT object by the owner.
     *
     * @param account ChainObject account chain object.
     * @return Nft object.
     */
    public List<NftData<? extends NftModel>> getNftByAccount(ChainObject account, BlockgetConnection connectionExample) {

        final DCoreApi dcoreApi = connectionExample.connect();

        return dcoreApi.getNftApi().getNftBalances(account).blockingGet();
    }



}
