package main.java.sgu.ru;

public class Clan implements Cloneable{
    public String clanName;
    public int value;

    public Clan(String name, int value) {
        this.clanName = name;
        this.value = value;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
