package ke.co.safaricom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeroTest {
    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {

    }

    public Hero setupNewHero() throws Exception{
        ArrayList<String> powers = new ArrayList<String>();
        ArrayList<String> name= new ArrayList<String>();
        ArrayList<String> weaknesses = new ArrayList<String>();
        powers.add("jump");
        name.add("james");
        powers.add("super strong");
        weaknesses.add("Impatience");
        weaknesses.add("slow");

        Hero hero = new Hero("Nick",25,powers,weaknesses,1);
        return  hero;
    }

    @Test
    public void HeroInstanceWithPowers_true() throws Exception{
        Hero hero = setupNewHero();
        assertTrue(hero.getPowers().contains("jump"));
    }


    @Test
    public void HeroInstanceWithName_true() throws Exception{
        Hero hero = setupNewHero();
        assertEquals("james",hero.getName());
    }

    @Test
    public void HeroInstanceWithAge_true() throws Exception{
        Hero hero = setupNewHero();
        assertEquals(25,hero.getAge());
    }
    @Test
    public void HeroInstanceWithWeaknesses_true() throws Exception{
        Hero hero = setupNewHero();
        assertTrue(hero.getWeaknesses().contains("slow"));
    }

};