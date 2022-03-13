package models;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HeroTest {
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void Hero_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Thor", 16, "lightning", "crypto", "Avengers");
        assertTrue(myHero instanceof Hero);
    }
    @Test
    public void instantiatesWithHeroAge() {
        Hero myHero = new Hero("superman", 36, "super strength", "crypto", "Infinity");
        assertEquals(36, myHero.getHeroAge());
    }
    @Test
    public void instantiatesWithHeroName_String() {
        Hero myHero = new Hero("superman", 36, "super strength", "crypto", "Infinity");
        assertEquals("superman", myHero.getName());
    }
    @Test
    public void Hero_instantiatesWithHeroAbility_String() {
        Hero myHero = new Hero("superman", 36, "super strength", "love", " Infinity");
        assertEquals("super strength", myHero.getHeroAbility());
    }
    @Test
    public void instantiatesWithHeroWeakness() {
        Hero myHero = new Hero("superman", 36, "super strength", "love", " Infinity");
        assertEquals("love", myHero.getHeroWeakness());
    }
    @Test
    public void instantiatesWithHeroSquad() {
        Hero myHero = new Hero("superman", 36, "super strength", "love", "Infinity");
        assertEquals("Infinity", myHero.getHeroSquad());
    }
    public void tearDown() throws Exception {
    }
}