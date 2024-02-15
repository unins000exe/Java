import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String task;

        loop:
        while (true) {
            System.out.print("""
                    1 - Вывести Hello, World!
                    2 - Задание 2
                    3 - Задание 3
                    Введите номер задания:\s""");
            task = sc.nextLine();

            switch(task) {
                case "1":
                    A1.hello();
                    break;

                case "2":
                    break;

                case "3":
                    break;

                default:
                    System.out.println("Завершение работы программы.");
                    break loop;
            }
        sc.close();
        }
    }
}