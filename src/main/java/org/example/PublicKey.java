package org.example;

public class PublicKey {

    public long[] generatePublicKey(long u, long v, long[] supersequence) {
        long[] publicKey = new long[supersequence.length];
        for (int i = 0; i < publicKey.length; i++) {
            publicKey[i] = (supersequence[i] * v) % u;
        }
        return publicKey;
    }
}
