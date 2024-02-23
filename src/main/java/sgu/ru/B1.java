package main.java.sgu.ru;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.math.RoundingMode;

public class B1 {
    private static BigDecimal calc(BigDecimal l, BigDecimal r, String op) throws Exception {
        return switch(op) {
            case "ADD" -> l.add(r);
            case "SUB" -> l.subtract(r);
            case "MULT" -> l.multiply(r);
            case "DIV" -> {
                if (r.equals(BigDecimal.ZERO)) {
                    throw new ArithmeticException("Деление на 0 запрещено.");
                }
                else
                {
                    yield l.divide(r, RoundingMode.HALF_EVEN);
                }
            }
            case "REM" -> {
                if (r.equals(BigDecimal.ZERO)) {
                    throw new ArithmeticException("Деление на 0 запрещено.");
                }
                else
                {
                    yield l.remainder(r);
                }
            }
            case "POW" -> l.pow(r.intValue());
            default -> throw new Exception("Что-то пошло не так.");
        };
    }

    private static BigInteger calc(BigInteger l, BigInteger r, String op) throws Exception {
        return switch(op) {
            case "ADD" -> l.add(r);
            case "SUB" -> l.subtract(r);
            case "MULT" -> l.multiply(r);
            case "DIV" -> {
                if (l.equals(BigInteger.ZERO)) {
                    throw new ArithmeticException("Деление на 0 запрещено.");
                }
                else
                {
                    yield l.divide(r);
                }
            }
            case "REM" -> {
                if (r.equals(BigInteger.ZERO)) {
                    throw new ArithmeticException("Деление на 0 запрещено.");
                }
                else
                {
                    yield l.remainder(r);
                }
            }
            case "POW" -> l.pow(r.intValue());
            default -> throw new Exception("Что-то пошло не так.");
        };
    }

    public static void call_calc() {
        Scanner sc = new Scanner(System.in);
        String left, right, op;

        System.out.print("Введите два числа и операцию: ");
        String[] params = sc.nextLine().split("\\s+");
        if (params.length == 3)
        {
            left = params[0];
            right = params[1];
            op = params[2];
        }
        else
        {
            System.out.println("Некорректный ввод.");
            sc.close();
            return;
        }

        if (left.contains(".") || right.contains("."))
        {
            BigDecimal l = new BigDecimal(left);
            BigDecimal r = new BigDecimal(right);
            try {
                BigDecimal result = calc(l, r, op);
                System.out.println(result);
            } catch (Exception ae) {
                System.out.println(ae.getMessage());
            }
        }
        else
        {
            BigInteger l = new BigInteger(left);
            BigInteger r = new BigInteger(right);
            try {
                BigInteger result = calc(l, r, op);
                System.out.println(result);
            } catch (Exception ae) {
                System.out.println(ae.getMessage());
            }
        }
        sc.close();
    }

}