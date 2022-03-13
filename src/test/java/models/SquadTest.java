package models;

import org.junit.Assert;
import org.junit.Before;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquadTest {
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void Squad_instantiatesCorrectly_true() {
        Squad mySquad = new Squad("marvel",  "computer illiteracy");
        assertEquals(true, mySquad instanceof Squad);
    }
    @Test
    public void returnsAllInstancesOfSquad_true() {
        Squad fsquad = new Squad("marvel",  "computer illiteracy");
        Squad squad = new Squad("Endgame",  "sexism");
        assertEquals(true, Squad.all().contains(fsquad));
        assertEquals(true, Squad.all().contains(squad));
    }
    @Test
    public void clearSquadFromArray() {
        Squad firstSquad = new Squad("Endgame",  "sexism");
        Squad.deleteAll();
        assertEquals(0, Squad.all().size());
    }
    @Test
    public void addsHeroToSquad_true() {
        Squad mySquad = new Squad("Endgame", "protect the earth");
        Hero myHero = new Hero("Captain America", 26, "Super Strong", "girlfriend", "Endgame");
        mySquad.addHero(myHero);
        System.out.println(mySquad.getHeroes().size());
        Assert.assertEquals(true, mySquad.getHeroes().contains(myHero));
    }
    public void tearDown() throws Exception {
    }
}