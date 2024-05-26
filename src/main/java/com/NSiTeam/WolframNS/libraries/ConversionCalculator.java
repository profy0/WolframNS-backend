package com.NSiTeam.WolframNS.libraries;

public class ConversionCalculator {

    private static int toDecimal(String number, int base) {
        int result = 0;
        int power = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            char digit = number.charAt(i);
            int value = Character.isDigit(digit) ? (digit - '0') : (digit - 'A' + 10);
            result += value * Math.pow(base, power);
            power++;
        }
        return result;
    }

    private static String fromDecimal(int number, int base) {
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int remainder = number % base;
            char digit = (char) (remainder < 10 ? remainder + '0' : remainder - 10 + 'A');
            result.insert(0, digit);
            number /= base;
        }
        return result.toString();
    }

    public static String convertBase(String number, int fromBase, int toBase) {
        int decimalValue = toDecimal(number, fromBase);
        return fromDecimal(decimalValue, toBase);
    }
}
