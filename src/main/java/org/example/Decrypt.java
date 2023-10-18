package org.example;

public class Decrypt {

    public String decrypt(long[] privateKey, long[] encryptedMessage, long u, long v) {
        String result = "";
        long getVminus = getVminus(u, v);
        for (int i = 0; i < encryptedMessage.length; i++) {
            String binary = "";
            encryptedMessage[i] = (encryptedMessage[i] * getVminus) % u;
            for (int j = privateKey.length-1; j >= 0; j--) {
                if (encryptedMessage[i] >= privateKey[j]) {
                    binary += "1";
                    encryptedMessage[i] -= privateKey[j];
                } else {
                    binary += "0";
                }
            }
            String reverse = "";
            for (int le = binary.length() - 1; le >= 0; le--) {
                reverse = reverse + binary.charAt(le);
            }

            String subOne = reverse.substring(0, 8);
            String subTwo = reverse.substring(8, 16);

            result += ((char) Integer.parseInt(subOne, 2)) +""+ (char) Integer.parseInt(subTwo, 2);
        }
        return result;
    }

    public long getVminus(long u, long v) {
        for (int i = 0; i < u; i++) {
            if (v * i % u == 1) {
                return i;
            }
        }
        return 0;
    }
}
