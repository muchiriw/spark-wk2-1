package ke.co.safaricom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeroTest {
    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {

    }


    @Test
    public void HeroInstanceWithPowers_true() throws Exception{
        Hero hero = setupNewHero();
        assertTrue(hero.getPowers().contains("Fly"));
    }

    private Hero setupNewHero() {
        Hero Hero = null;
        return  Hero;
    }

    @Test
    public void HeroInstanceWithName_true() throws Exception{
        Hero hero = setupNewHero();
        assertEquals("Nick",hero.getName());
    }

    @Test
    public void HeroInstanceWithAge_true() throws Exception{
        Hero hero = setupNewHero();
        assertEquals(25,hero.getAge());
    }
    @Test
    public void HeroInstanceWithWeaknesses_true() throws Exception{
        Hero hero = setupNewHero();
        assertTrue(hero.getWeaknesses().contains("Lazy"));
    }

}}