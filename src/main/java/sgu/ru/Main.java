package main.java.sgu.ru;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Character c1 = new Character("Монстр1", 15, 3);
        Character c2 = new Character("Монстр2", 15, 5);
        Character c3 = new Character("Монстр3", 10, 5);
        Knight k1 = new Knight("Рыцарь1", 20, 3, 10);
        k1.characterClan = new Clan("Barboskin", 12);
        Wizard w1 = new Wizard("Маг1", 5, 3, 30);

        List<Character> characters = new ArrayList<>();
        characters.add(c1);
        characters.add(c2);
        characters.add(c3);
        characters.add(k1);
        characters.add(w1);

        System.out.printf("Хэш-коды объектов %s и %s: %d, %d \n", k1.name, w1.name, k1.hashCode(), w1.hashCode());
        System.out.println();

        System.out.println("-------До сортировки--------");
        for (Character u : characters) {
            System.out.println(u);
        }
        System.out.println("-------После сортировки-----");
        Collections.sort(characters);

        for (Character u : characters) {
            System.out.println(u);
        }
        System.out.println();

        System.out.println("Демонстрация работы поверхностного копирования");
        Knight k2 = (Knight) k1.clone();
        System.out.println(k1.characterClan.clanName);
        System.out.println(k2.characterClan.clanName);
        k1.characterClan.clanName = "ChipiChapa";
        System.out.println(k1.characterClan.clanName);
        System.out.println(k2.characterClan.clanName);
        System.out.println();

        System.out.println("Демонстрация работы глубокого копирования");
        Knight k3 = (Knight) k1.clone2();
        System.out.println(k1.characterClan.clanName);
        System.out.println(k3.characterClan.clanName);
        k1.characterClan.clanName = "DreamTeam";
        System.out.println(k1.characterClan.clanName);
        System.out.println(k3.characterClan.clanName);
        System.out.println();

        k1.get_attacked(w1);
        w1.get_attacked(k1);
        c1.get_attacked(c2);
        c2.get_attacked(k1);

    }
}