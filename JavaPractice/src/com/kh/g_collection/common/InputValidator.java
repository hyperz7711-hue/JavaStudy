package com.kh.g_collection.common;

import java.util.Scanner;

public class InputValidator {
    private static final int MAX_TRIES = 5;

    // 정수 입력 & 음수 방지
    public static int getPositiveInt(Scanner sc, String message) {
        int tries = 0;
        while (tries < MAX_TRIES) {
            System.out.print(message);
            String input = sc.nextLine();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) return value;
                else System.out.println("양수를 입력하세요.");
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력하세요.");
            }
            tries++;
        }
        System.out.println("입력 오류가 5회 발생하여 프로그램을 종료합니다.");
        System.exit(0);
        return -1; // Unreachable
    }

    // 특정 문자만 허용 (예: 'M', 'F')
    public static char getAllowedChar(Scanner sc, String message, char... allowed) {
        int tries = 0;
        while (tries < MAX_TRIES) {
            System.out.print(message);
            String input = sc.nextLine().toUpperCase();
            if (input.length() == 1) {
                char ch = input.charAt(0);
                for (char a : allowed) {
                    if (ch == a) return ch;
                }
            }
            System.out.println("허용되지 않은 입력입니다. 다시 입력하세요.");
            tries++;
        }
        System.out.println("입력 오류가 5회 발생하여 프로그램을 종료합니다.");
        System.exit(0);
        return 'X'; // Unreachable
    }

    // 소수 입력 (소수점 자리수 제한)
    public static double getDoubleWithPrecision(Scanner sc, String message, int maxDecimalPlaces) {
        int tries = 0;
        while (tries < MAX_TRIES) {
            System.out.print(message);
            String input = sc.nextLine();
            try {
                double value = Double.parseDouble(input);
                String[] parts = input.split("\\.");
                if (parts.length == 1 || parts[1].length() <= maxDecimalPlaces) {
                    return value;
                } else {
                    System.out.println("소수점은 최대 " + maxDecimalPlaces + "자리까지만 허용됩니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("실수를 입력하세요.");
            }
            tries++;
        }
        System.out.println("입력 오류가 5회 발생하여 프로그램을 종료합니다.");
        System.exit(0);
        return -1; // Unreachable
    }
}