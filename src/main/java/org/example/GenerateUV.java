package org.example;

import java.util.Random;

public class GenerateUV {

    public long numberU(long[] supersequence) {
        Random random = new Random();
        long sum = 0;
        for (int i = 0; i < supersequence.length; i++) {
            sum += supersequence[i];
        }
        sum += random.nextInt(100) + 1;
        while (!isPrime(sum)) {
            sum++;
        }
        return sum;
    }

    public long numberV(long numberU) {
        Random random = new Random();
        long v = numberU + random.nextLong((numberU - 1) - 1) + 1;
        while (!isPrime(v)) {
            v = random.nextLong((numberU - 1) - 1) + 1;
        }

        // check if v is greater than numberU and if so, call numberV again until it is not
        if (v >= numberU)
            return numberV(numberU);

        return v;
    }

    public boolean isPrime(long n) {
        if (n <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
