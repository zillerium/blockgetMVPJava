package com.blockget.blockchain;

import ch.decent.sdk.DCoreApi;
import ch.decent.sdk.crypto.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlockgetLogin {

    private final static String ACCOUNT_NAME = "public-account-10";
    private final static String PRIVATE_KEY = "5JMpT5C75rcAmuUB81mqVBXbmL1BKea4MYwVK6voMQLvigLKfrE";

    @Autowired
   // private com.blockget.blockchain.BlockgetConnection connectionExample;

    /**
     * Example of logging into the DECENT test network with private key.
     *
     * @return Credentials to use for other API calls.
     */
    public Credentials login(BlockgetConnection connectionExample) {

        final DCoreApi dcoreApi = connectionExample.connect();

        return dcoreApi
                .getAccountApi()
                .createCredentials(ACCOUNT_NAME, PRIVATE_KEY)
                .blockingGet();
    }
}
