package org.example;

public class Encrypt {

    public long[] encrypt(long[] publicKey, String[] binaryKey) {
        long[] results = new long[binaryKey.length];

        for (int i = 0; i < binaryKey.length; i++) {
            String binaryString = binaryKey[i];

            char[] binaryArray = binaryString.toCharArray();

            for (int j = 0; j < binaryArray.length; j++) {
                results[i] += Character.getNumericValue(binaryArray[j]) * publicKey[j];
            }
        }
        return results;
    }

    public String[] getBinary(int[] message) {
        int pairCount = message.length / 2;
        int remaining = message.length % 2;
        String[] concatenatedBinaryStrings = new String[pairCount + remaining];

        for (int i = 0; i < pairCount; i++) {
            int num1 = message[i * 2];
            int num2 = message[i * 2 + 1];

            String binary1 = Integer.toBinaryString(num1);
            String binary2 = Integer.toBinaryString(num2);

            while (binary1.length() < 8) {
                binary1 = "0" + binary1;
            }

            while (binary2.length() < 8) {
                binary2 = "0" + binary2;
            }

            concatenatedBinaryStrings[i] = binary1 + binary2;
        }
        for (int i = 0; i < remaining; i++) {
            int num = message[pairCount * 2 + i];
            String binary = Integer.toBinaryString(num);

            while (binary.length() < 8) {
                binary = "0" + binary;
            }
            concatenatedBinaryStrings[pairCount + i] = binary;
        }
        return concatenatedBinaryStrings;
    }

    public int[] charToint(String message) {
        int[] intMessage = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            intMessage[i] = (int) message.charAt(i);
        }
        return intMessage;
    }
}
