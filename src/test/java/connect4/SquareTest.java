package connect4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Adrien on 24/11/2016.
 */
public class SquareTest {

    private Token square;

    @Before
    public  void init() {
        square = new Token();
    }

    @Test
    public void TokenInstantiation() {
        Token toto = new Token();
    }

    @Test (expected = RuntimeException.class)
    public void GetValueSquare () {
        assertEquals(" ", square.getValue());
        square.setValue("X");
        assertEquals("X", square.getValue());
        square.setValue("toto");
        assertEquals("X", square.getValue());
    }
}