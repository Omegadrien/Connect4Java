package connect4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adrien on 24/11/2016.
 */
public class GameTest {

    private Game game;

    @Before
    public void Init () {
        game = new Game();
    }

    @Test
    public void InstantiationGame() {
        Game game1 = new Game();
    }
}