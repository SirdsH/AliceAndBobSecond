package org.example;

import java.util.Random;

public class Supersequence {
    public long[] generateSS(int length) {
        Random random = new Random();
        long[] result = new long[length];
        long sum = 0;
        for (int i = 0; i < result.length; i++) {
            long rand = random.nextInt(10) + sum + 1;
            result[i] = rand;
            sum += rand;
        }
        return result;
    }
}
