package com.company;

public class Main {

    public static void main(String[] args) {
        float a = 2;
        float b = 6;
        System.out.println("P = " + P (a, b));
        System.out.println("S = " + S (a, b));
    }
    public static float P (float A, float B) {
       float P = 2*A + 2*B;
        return P;
    }
    public static float S (float A, float B) {
        float S = A*B;
        return S;
    }
}