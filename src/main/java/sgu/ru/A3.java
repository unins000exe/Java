package main.java.sgu.ru;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class A3 {
    public static void filterStream(Scanner sc) {
        System.out.print("Введите числа: ");
        String input = sc.nextLine();
        Stream<Integer> numbers = Arrays.stream(input.split(" "))
                .map(Integer::parseInt);

        List<Integer> evenNumbers = filterNumbers(numbers, n -> n % 2 == 0);
        System.out.println(evenNumbers);
    }

    public static List<Integer> filterNumbers(Stream<Integer> numbers, Predicate<Integer> condition) {
        return numbers.filter(condition).collect(Collectors.toList());
    }
}
