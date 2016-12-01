package connect4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adrien on 24/11/2016.
 */
public class GameTest {

    private Game partie;

    @Before
    public void Init () {
        partie = new Game();
    }

    @Test
    public void IntanciationGame() {
        Game partie = new Game();
    }

    /*@Test
    public void TestTourDeJeuPilePleine() {
        Player j = new Player("X");
        partie.Turn(j);
        partie.Turn(j);
        partie.Turn(j);
        partie.Turn(j);
        partie.Turn(j);
        partie.Turn(j);

        boolean jetonPlace = partie.Turn(j);
        assertFalse(jetonPlace);
    }
    */

}