package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Supersequence supersequence = new Supersequence();
        GenerateUV generateUV = new GenerateUV();
        PublicKey publicKey = new PublicKey();
        Encrypt encrypt = new Encrypt();
        Decrypt decrypt = new Decrypt();
        System.out.println("Vítejte v aplikaci!!!");
        System.out.println("Zadejte délku superposloupnosti: ");
        int length = Integer.parseInt(sc.nextLine());
        System.out.println(length);
        long[] ss = supersequence.generateSS(length);
        long u = generateUV.numberU(ss);
        long v = generateUV.numberV(u);
        long vminus = decrypt.getVminus(u, v);
        System.out.println("Kdo jsi?");
        System.out.println("1. Alice");
        System.out.println("2. Bob");
        int who = Integer.parseInt(sc.nextLine());
        if (who == 1) {
            long[] alicePublicKey = publicKey.generatePublicKey(u, v, ss);
            System.out.println("Public Key: " + Arrays.toString(alicePublicKey));
            System.out.println("_______________");
            String[] inputMessage = sc.nextLine().split(", ");
            long[] message = new long[inputMessage.length];
            for (int i = 0; i < inputMessage.length; i++) {
                message[i] = Long.parseLong(inputMessage[i]);
            }
            System.out.println("Message: " + decrypt.decrypt(ss, message, u, v));

        } else if (who == 2) {
            System.out.println("Input the public key:");
            String input = sc.nextLine().replace(" ", "");
            System.out.println(input);
            String[] publicKeyString = input.split(",");
            System.out.println(Arrays.toString(publicKeyString));
            long[] publicKeyArray = new long[publicKeyString.length];
            for (int i = 0; i < publicKeyString.length; i++) {
                publicKeyArray[i] = Long.parseLong(publicKeyString[i]);
            }
            System.out.println("Public Key: " + Arrays.toString(publicKeyArray));
            String message = sc.nextLine();
            int[] intMessage = encrypt.charToint(message);
            System.out.println("Message: " + Arrays.toString(intMessage));
            String[] binary = encrypt.getBinary(intMessage);
            System.out.println("Binary: " + Arrays.toString(binary));
            long[] encrypted = encrypt.encrypt(publicKeyArray, binary);
            for (int i = 0; i < encrypted.length; i++) {
                System.out.print(encrypted[i] + ", ");
            }
        }

    }
}
