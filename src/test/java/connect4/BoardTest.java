package connect4;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board test;

    @Before
    public void Init() {
        test = new Board();
    }

    @Test
    public void TestCreationBoard() {
        Board board = new Board();
    }

    @Test (expected = RuntimeException.class)
    public void TestLocationOfToken() {
        test.PutASquare(8, "X");
    }

    @Test (expected = FullStackException.class)
    public void FullStack() {
        test.PutASquare(1, "X");
        test.PutASquare(1, "X");
        test.PutASquare(1, "X");
        test.PutASquare(1, "X");
        test.PutASquare(1, "X");
        test.PutASquare(1, "X");
        test.PutASquare(1, "X");
    }

    @Test (expected = TableOverflowException.class)
    public void PutOutOfRangeSquare() {
        test.PutASquare(8,"X");
    }

}