package dev.dockeray.datastructures.ch1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTest {

    @Test
    void r1_10() {
        assertTrue(Simple.r1_10(10, 2));
    }

    @Test
    void isOdd() {
        assertTrue(Simple.isOdd(3));
        assertFalse(Simple.isOdd(4));
    }

    @Test
    void oddProduct() {
        int[] vals = {1, 2, 3};
        assertTrue(Simple.oddProduct(vals));
        vals = new int[]{2};
        assertFalse(Simple.oddProduct(vals));
        vals = new int[]{2,4};
        assertFalse(Simple.oddProduct(vals));
    }

    @Test
    void isDistinct() {
        Integer[] vals = {1, 2, 3};
        assertTrue(Simple.isDistinct(vals));
        vals = new Integer[]{4,4};
        assertFalse(Simple.isDistinct(vals));
    }
}