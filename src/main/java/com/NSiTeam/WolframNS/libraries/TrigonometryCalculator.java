package com.NSiTeam.WolframNS.libraries;

public class TrigonometryCalculator {

    public static double calculateSin(double angle, int terms) {
        double result = 0;
        for (int n = 0; n < terms; n++) {
            result += Math.pow(-1, n) * Math.pow(angle, 2 * n + 1) / factorial(2 * n + 1);
        }
        return Math.round(result * 1e5) / 1e5;
    }

    public static double calculateCos(double angle, int terms) {
        double result = 0;
        for (int n = 0; n < terms; n++) {
            result += Math.pow(-1, n) * Math.pow(angle, 2 * n) / factorial(2 * n);
        }
        return Math.round(result * 1e5) / 1e5;
    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}