package com.rotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResultTests {
    private List<List<Integer>> matrix;

    @BeforeEach
    void setUp() {
        matrix = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16)
        );
    }

    @Test
    void testMatrixRotation() {
        Result.matrixRotation(matrix, 2);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3, 4, 8, 12),
                Arrays.asList(2, 11, 10, 16),
                Arrays.asList(1, 7, 6, 15),
                Arrays.asList(5, 9, 13, 14)
        );

        assertEquals(expected, matrix);
    }

    @Test
    void testMatrixRotationWithLargerMatrix() {
        matrix = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7, 8, 9, 10),
                Arrays.asList(11, 12, 13, 14, 15),
                Arrays.asList(16, 17, 18, 19, 20),
                Arrays.asList(21, 22, 23, 24, 25)
        );

        Result.matrixRotation(matrix, 3);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(4, 5, 10, 15, 20),
                Arrays.asList(3, 14, 19, 18, 25),
                Arrays.asList(2, 9, 13, 17, 24),
                Arrays.asList(1, 8, 7, 12, 23),
                Arrays.asList(6, 11, 16, 21, 22)
        );

        assertEquals(expected, matrix);
    }

    @Test
    void testRotationEdgeCase() {
        matrix = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        Result.matrixRotation(matrix, 12);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(9, 8, 7),
                Arrays.asList(6, 5, 4),
                Arrays.asList(3, 2, 1)
        );

        assertEquals(expected, matrix);
    }
}
