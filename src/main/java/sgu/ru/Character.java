package main.java.sgu.ru;

public class Character {
    public String name;
    public int health;
    public int damage;

    public Character(String name, int health, int damage) {
        this.health = health;
        this.damage = damage;
        this.name = name;
    }

    public int hashCode() {
        return health + damage * 10;
    }

    public void get_attacked(Character enemy)
    {
        this.health -= enemy.damage;
        System.out.printf("%s нанёс %d урона %s \n", enemy.name, enemy.damage, this.name);
        System.out.printf("У %s осталось очков здоровья %d \n", this.name, this.health);
    }

}
