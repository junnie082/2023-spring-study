package org.example.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTypeTest {
    @Test
    public void testGetTypeCode () {
        assertEquals(DataType.TYPE_0.getTypeCode(), 0);
        assertEquals(DataType.TYPE_1.getTypeCode(), 1);
    }
}