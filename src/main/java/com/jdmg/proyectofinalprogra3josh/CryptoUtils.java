package com.jdmg.proyectofinalprogra3josh;

public class CryptoUtils {

    private static final int SHIFT = 7;

    public static String encrypt(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append((char) ('A' + (c - 'A' + SHIFT) % 26));
            } else if (Character.isLowerCase(c)) {
                sb.append((char) ('a' + (c - 'a' + SHIFT) % 26));
            } else if (Character.isDigit(c)) {
                // DESPLAZAMOS dígitos 0–9
                int d = c - '0';
                sb.append((char) ('0' + (d + SHIFT) % 10));
            } else if (c == '.') {
                sb.append(c); // deja intacto el punto decimal
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /*
    public static String decrypt(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append((char) ('A' + (c - 'A' - SHIFT + 26) % 26));
            } else if (Character.isLowerCase(c)) {
                sb.append((char) ('a' + (c - 'a' - SHIFT + 26) % 26));
            } else if (Character.isDigit(c)) {
                int d = c - '0';
                sb.append((char) ('0' + (d - SHIFT + 10) % 10));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }*/
    public static String decrypt(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append((char) ('A' + (c - 'A' - SHIFT + 26) % 26));
            } else if (Character.isLowerCase(c)) {
                sb.append((char) ('a' + (c - 'a' - SHIFT + 26) % 26));
            } else if (Character.isDigit(c)) {
                int d = c - '0';
                sb.append((char) ('0' + (d - SHIFT + 10) % 10));
            } else if (c == '.') {
                sb.append('.'); // deja el punto como está
            } else if (c == ',') {
                sb.append(',');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
