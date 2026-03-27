package com.skills.utils;

import java.util.Scanner;

public class InputUtils {

    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    public static double getDouble(String message) {
        System.out.print(message);
        return sc.nextDouble();
    }

    public static String getString(String message) {
        System.out.print(message);
        sc.nextLine();
        return sc.nextLine();
    }
}