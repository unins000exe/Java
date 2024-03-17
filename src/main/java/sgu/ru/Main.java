package main.java.sgu.ru;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Character character1 = new Character(1, "Монстр1", 15, 3);
        Character character2 = new Character(2, "Монстр2", 15, 5);
        Character c3 = new Character(3, "Монстр3", 10, 5);
        Knight knight = new Knight(4, "Рыцарь1", 20, 3, 10);
        Knight knight2 = new Knight(5, "Рыцарь2", 20, 3, 10);
        knight.characterClan = new Clan("Barboskin", 12);
        Wizard wizard = new Wizard(5, "Маг1", 5, 3, 30);

        List<Character> characters = new ArrayList<>();
        characters.add(character1);
        characters.add(character2);
        characters.add(c3);
        characters.add(knight);
        characters.add(wizard);

        System.out.printf("Хэш-коды объектов %s и %s: %d, %d \n", knight.name, wizard.name, knight.hashCode(), wizard.hashCode());
        System.out.println();

        System.out.println("Cравнение двух неравных персонажей");
        String compareResult;
        if (character1.equals(character2))
            compareResult = "равен";
        else
            compareResult = "не равен";
        System.out.printf("%s %s %s\n", character1.name, compareResult, character2.name);
        System.out.println();

        System.out.println("Cравнение двух равных персонажей");
        if (knight.equals(knight2))
            compareResult = "равен";
        else
            compareResult = "не равен";
        System.out.printf("%s %s %s\n", knight.name, compareResult, knight2.name);
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
        Knight knightCloned = (Knight) knight.clone();
        System.out.println(knight.characterClan.clanName);
        System.out.println(knightCloned.characterClan.clanName);
        knight.characterClan.clanName = "ChipiChapa";
        System.out.println(knight.characterClan.clanName);
        System.out.println(knightCloned.characterClan.clanName);
        System.out.println();

        System.out.println("Демонстрация работы глубокого копирования");
        Knight knightDeepCloned = (Knight) knight.deepClone();
        System.out.println(knight.characterClan.clanName);
        System.out.println(knightDeepCloned.characterClan.clanName);
        knight.characterClan.clanName = "DreamTeam";
        System.out.println(knight.characterClan.clanName);
        System.out.println(knightDeepCloned.characterClan.clanName);
        System.out.println();

        knight.getAttacked(wizard);
        wizard.getAttacked(knight);
        character1.getAttacked(character2);
        character2.getAttacked(knight);

    }
}