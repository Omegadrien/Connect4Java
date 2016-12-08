package connect4;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void PlayerCreation() {
        Player player = new Player("X");
        assertEquals("X", player.getSymbol());
    }

    @Test (expected = BadSymbolException.class)
    public void PlayerCreationIsOK() {
        Player player = new Player("lol");
    }
}