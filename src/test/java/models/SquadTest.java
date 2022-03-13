package models;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SquadTest {
    @Before
    public void setUp() {
    }
    @Test
    public void Squad_instantiatesCorrectly_true() {
        new Squad("marvel", "computer illiteracy");
        assertTrue(true);
    }
    @Test
    public void returnsAllInstancesOfSquad_true() {
        Squad fsquad = new Squad("marvel",  "computer illiteracy");
        Squad squad = new Squad("Endgame",  "sexism");
        assertTrue(Squad.all().contains(fsquad));
        assertTrue(Squad.all().contains(squad));
    }
    @Test
    public void clearSquadFromArray() {
        new Squad("Endgame", "sexism");
        Squad.deleteAll();
        assertEquals(0, Squad.all().size());
    }
    @Test
    public void addsHeroToSquad_true() {
        Squad mySquad = new Squad("Endgame", "protect the earth");
        Hero myHero = new Hero("Captain America", 26, "Super Strong", "girlfriend", "Endgame");
        mySquad.addHero(myHero);
        System.out.println(mySquad.getHeroes().size());
        assertTrue(mySquad.getHeroes().contains(myHero));
    }
    public void tearDown() {
    }
}