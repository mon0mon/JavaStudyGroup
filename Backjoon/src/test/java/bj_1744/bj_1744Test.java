package bj_1744;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class bj_1744Test {

    @Test
    void case01() throws IOException {
        System.setIn(new ByteArrayInputStream("4\n-1\n2\n1\n3\n".getBytes()));
        assertEquals(6, bj_1744.solution());
    }

    @Test
    void case02() throws IOException {
        System.setIn(new ByteArrayInputStream("6\n0\n1\n2\n4\n3\n5".getBytes()));
        assertEquals(27, bj_1744.solution());
    }

    @Test
    void case03() throws IOException {
        System.setIn(new ByteArrayInputStream("1\n-1".getBytes()));
        assertEquals(-1, bj_1744.solution());
    }

    @Test
    void case04() throws IOException {
        System.setIn(new ByteArrayInputStream("3\n-1\n0\n1\n".getBytes()));
        assertEquals(1, bj_1744.solution());
    }

    @Test
    void case05() throws IOException {
        System.setIn(new ByteArrayInputStream("2\n1\n1\n".getBytes()));
        assertEquals(2, bj_1744.solution());
    }

    @Test
    void case06() throws IOException {
        System.setIn(new ByteArrayInputStream("6\n-1\n-1\n0\n1\n3\n5\n".getBytes()));
        assertEquals(17, bj_1744.solution());
    }
}