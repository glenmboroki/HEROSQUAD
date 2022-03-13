package models;



import java.util.ArrayList;

import java.util.List;

public class Squad {
    private int squadId;
    private String name;
    private String squadCause;
    private int maxSize;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private static ArrayList<Hero> myHeroes = new ArrayList<>();
    private List<Hero> squadHeroes = new ArrayList<>();

    public Squad(String squad_name, String squad_cause) {
        name = squad_name;
//        maxSize = size;
        squadCause = squad_cause;
        this.myHeroes = new ArrayList<>();
        instances.add(this);
        this.squadId = instances.size();

    }

    public static List<Squad> all() {

        return instances;
    }

    public static void deleteAll() {
        instances.clear();
    }

    public int getSquadId() {
        return squadId;
    }

    public static Squad findById(int id) {
        return instances.get(id - 1);
    }

    public String getSquadName() {
        return name;
    }

    public boolean checkForMaxMembers() {
        return myHeroes.size() <= this.maxSize;
    }

    public String getCause() {
        return this.squadCause;
    }

    public static ArrayList<Squad> getAll() {
        return instances;
    }

    public ArrayList<Hero> getMyHeroes() {
        return myHeroes;
    }

    public List<Hero> getSquadHeroes() {
        return this.squadHeroes;
    }

    public boolean doesHeroExist(Hero hero) {
        int counter = 0;
        for (Hero mHero : myHeroes) {
            if (mHero.getName().equals(hero.getName())) {
                counter++;
            }
        }

        return counter != 1;
    }

    public String getName() {
        return this.name;
    }

    public static void clearAllSquads() {
        instances.clear();
    }

    public ArrayList<Hero> getHeroes() {
        return myHeroes;
    }

    public void addHero(Hero myHero) {
    }
}
