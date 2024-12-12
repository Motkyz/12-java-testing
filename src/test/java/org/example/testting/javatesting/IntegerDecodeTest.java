package org.example.testting.javatesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerDecodeTest {

    @Test
    void testNullArgument() {
        assertThrows(NullPointerException.class, () -> Integer.decode(null));
    }

    @Test
    void testEmptyString() {
        assertThrows(NumberFormatException.class, () -> Integer.decode(""));
    }

    @Test
    void testSimpleDecimal() {
        assertEquals(1234, Integer.decode("1234"));
    }

    @Test
    void testHexadecimal() {
        assertEquals(171, Integer.decode("0xAB"));
    }

    @Test
    void testHexadecimal1() {
        assertEquals(171, Integer.decode("#AB"));
    }

    @Test
    void testOctadecimal() {
        assertEquals(63, Integer.decode("077"));
    }

    @Test
    void testNegativeNumber() {
        assertEquals(-1234, Integer.decode("-1234"));
    }

    @Test
    void testInvalidNumber() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("4-2"));
    }

    @Test
    void testInvalidString() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("abc"));
    }

    @Test
    void testOverflow() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("9999999999"));
    }
}