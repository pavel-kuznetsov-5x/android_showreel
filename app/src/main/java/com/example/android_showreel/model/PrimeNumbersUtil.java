package com.example.android_showreel.model;

public class PrimeNumbersUtil {

    public static boolean isPrime(int number) {
        boolean isPrime = true;
        for (int i = 2; i*i <= number; i++) {
            if(number % i != 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

}
