package main.java.sgu.ru;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String task;

        System.out.print("""
                    1 - Вывести Hello, World!
                    2 - Задание 2
                    3 - Задание 3
                    """);

        loop:
        while (true) {
            System.out.print("Введите номер задания: ");
            task = sc.nextLine();

            switch(task) {
                case "1":
                    A1.hello();
                    break;

                case "2":
                    B1.call_calc(sc);
                    break;

                case "3":
                    C1.read_file();
                    break;

                default:
                    sc.close();
                    System.out.println("Завершение работы программы.");
                    break loop;
            }
        }
    }
}