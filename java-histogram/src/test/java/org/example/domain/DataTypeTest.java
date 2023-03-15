package org.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTypeTest {
    @Test
    public void testDataCode () {
        assertEquals(DataType.TYPE_0, 0);
        assertEquals(DataType.TYPE_1, 1);
    }
}