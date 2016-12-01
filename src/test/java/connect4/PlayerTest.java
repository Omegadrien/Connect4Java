package connect4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adrien on 24/11/2016.
 */
public class PlayerTest {

    @Test
    public void CreationJoueur() {
        Player j = new Player("X");
        assertEquals("X", j.getSymbole());
    }

    @Test (expected = BadSymbolException.class)
    public void CreationJoueurValide() {
        Player j = new Player("lol");
    }
}