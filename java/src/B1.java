import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.math.RoundingMode;

public class B1 {
    private static BigDecimal bg_calc(BigDecimal bdl, BigDecimal bdr, String op) throws Exception {
        return switch(op) {
            case "ADD" -> bdl.add(bdl);
            case "SUB" -> bdl.subtract(bdl);
            case "MULT" -> bdl.multiply(bdl);
            case "DIV" -> {
                if (bdr.equals(BigDecimal.ZERO)) {
                    yield bdl.divide(bdr, RoundingMode.HALF_EVEN);
                }
                else
                {
                    throw new ArithmeticException("Деление на 0 запрещено.");
                }
            }
            case "REM" -> bdl.remainder(bdr);
            case "POW" -> bdl; // TODO
            default -> throw new Exception("Что-то пошло не так.");
        };
    }
    public static void calc(Scanner sc) {
        System.out.print("Введите два числа и операцию: ");
        String left = sc.next();
        String right = sc.next();
        String op = sc.next();

        if (left.contains(".") || right.contains("."))
        {
            BigDecimal bdl = new BigDecimal(left);
            BigDecimal bdr = new BigDecimal(right);
            try {
                BigDecimal result = bg_calc(bdl, bdr, op);
                System.out.println(result);
            } catch (Exception ae) {
                System.out.println(ae.getMessage());
            }
        }
        else
        {
            BigInteger bil = new BigInteger(left);
            BigInteger bir = new BigInteger(right);
        }
    }

}