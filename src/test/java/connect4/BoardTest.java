package connect4;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Adrien on 24/11/2016.
 */
public class BoardTest {

    private Board test;

    @Before
    public void Init() {
        test = new Board();
    }

    @Test
    public void TestCreationBoard() {
        Board toto = new Board();
    }

    @Test (expected = RuntimeException.class)
    public void TestLocationToken() {
        test.PutASquare(8, "X");
    }

    @Test (expected = FullStackExeption.class)
    public void FullStack() {
        test.PutASquare(1, "X");
        test.PutASquare(1, "X");
        test.PutASquare(1, "X");
        test.PutASquare(1, "X");
        test.PutASquare(1, "X");
        test.PutASquare(1, "X");
        test.PutASquare(1, "X");
    }

    @Test (expected = TableOverflow.class)
    public void PutOutOfRangeSquare() {
        test.PutASquare(8,"X");
    }

}