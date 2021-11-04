package com.geekbrains.lesson4;

public class Triangle {

    public static double sumNumbers(int a, int b, int c) {
        double s = 0;
        if (a+b < c || a+c < b || b+c < a) {
            System.out.println("Треугольника со сторонами" +
                    " a=" + a +" b="+b +" c="+c + " не существует");
            return s;
        }
        double p = (a + b + c) / 2;
        s = Math.pow(p * (p - a) * (p - b) * (p - c), 1.0 / 2);
        return s;
    }
}
