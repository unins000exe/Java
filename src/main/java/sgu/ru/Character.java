package main.java.sgu.ru;

public class Character implements Comparable<Character>, Cloneable{
    public String name;
    public Clan characterClan;
    public int health;
    public int damage;
    public int id;

    public Character(int id, String name, int health, int damage) {
        this.id = id;
        this.health = health;
        this.damage = damage;
        this.name = name;
    }

    public int hashCode() {
        return id;
    }

    public boolean equals(Character other)
    {
        if (this.health != other.health)
            return false;

        if (this.damage != other.damage)
            return false;

        return true;
    }

    @Override
    public int compareTo(Character other)
    {
        int result = this.health - other.health;
        if (result == 0)
        {
            result = this.damage - other.damage;
        }
        return result;
    }

    public String toString()
    {
        return this.name + " {" + Integer.toString(this.health) + ", " + Integer.toString(this.damage) + "}";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    protected Object deepClone() throws CloneNotSupportedException {
        Character character = (Character) super.clone();
        character.characterClan = (Clan) this.characterClan.clone();
        return character;
    }

    public void getAttacked(Character enemy)
    {
        this.health -= enemy.damage;
        System.out.printf("%s нанёс %d урона %s \n", enemy.name, enemy.damage, this.name);
        System.out.printf("У %s осталось очков здоровья %d \n", this.name, this.health);
    }

}
