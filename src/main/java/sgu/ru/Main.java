package main.java.sgu.ru;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String task;

        System.out.print("""
                    1 - Задание 1
                    2 - Задание 2
                    3 - Задание 3
                    """);

        loop:
        while (true) {
            System.out.print("Введите номер задания: ");
            task = sc.nextLine();

            switch(task) {
                case "1":
                    A3.filterStream(sc);
                    break;

                case "2":
                    break;

                case "3":
                    break;

                default:
                    sc.close();
                    System.out.println("Завершение работы программы.");
                    break loop;
            }
        }
    }
}