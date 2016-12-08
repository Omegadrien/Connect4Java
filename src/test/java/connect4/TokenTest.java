package connect4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TokenTest {

    private Token token;

    @Before
    public  void init() {
        token = new Token();
    }

    @Test
    public void TokenInstantiation() {
        Token token = new Token();
    }

    @Test (expected = RuntimeException.class)
    public void GetValueSquare () {
        assertEquals(" ", token.getValue());
        token.setValue("X");
        assertEquals("X", token.getValue());
        token.setValue("toto");
        assertEquals("X", token.getValue());
    }
}