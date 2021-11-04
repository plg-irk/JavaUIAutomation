package com.geekbrains.lesson4;

public class Triangle {

    public static double sumNumbers(int a, int b, int c) {
        double p = (a + b + c) / 2;
        double s = Math.pow(p * (p - a) * (p - b) * (p - c), 1.0 / 2);
        return s;
    }
}
