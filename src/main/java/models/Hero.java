package models;

import java.util.ArrayList;


public class Hero {

    private String name;
    private int heroAge;
    private String heroAbility;
    private String heroWeakness;
    private String heroSquad;
    private int id;
    private static ArrayList<Hero> instances = new ArrayList<Hero>();

    public Hero(String name, int age, String ability, String weakness,String heroSquad){
        this.name = name;
        this.heroAge = age;
        this.heroAbility = ability;
        this.heroWeakness = weakness;
        this.heroSquad=heroSquad;
        this.instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return name;
    }
    public void setName(String heroName) {
        this.name = heroName;
    }

    public int getHeroAge() {
       return this.heroAge;
    }


    public String getHeroAbility() {
        return heroAbility;
    }

    public void setHeroAge(int heroAge) {
        this.heroAge = heroAge;
    }

    public void setHeroAbility(String heroAbility) {
        this.heroAbility = heroAbility;
    }

    public void setHeroWeakness(String heroWeakness) {
        this.heroWeakness = heroWeakness;
    }

    public void setHeroSquad(String heroSquad) {
        this.heroSquad = heroSquad;
    }

    public String getHeroWeakness() {
        return heroWeakness;
    }


    public static ArrayList<Hero> getAll() {return instances;}
    public static void clearAllHeroes(){instances.clear();}
    public int getId(){return id;}
    public static void clearHeroes() {
        instances.clear();
    }
    public static Hero findById(int id) {
        return instances.get(id - 1);
    }
    public void deleteHero(){
        instances.remove(id - 1);
    }

//    public String getHeroName() {

    public String getHeroSquad() {
        return heroSquad;
    }
}
