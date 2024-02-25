package main.java.sgu.ru;


public class Main {
    public static void main(String[] args) {
        Knight c1 = new Knight("Рыцарь", 10, 3, 10);
        Character c2 = new Character("Монстр", 15, 3);
        Wizard c3 = new Wizard("Маг", 5, 3, 30);

        c1.get_attacked(c3);
        c3.get_attacked(c1);
    }
}