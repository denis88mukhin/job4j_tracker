package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class ConvertList2ArrayTest {

    @Test
    void when7ElementsTest() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result).isDeepEqualTo(expected);
    }

    @Test
    void when5ElementsThen6() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5),
                2
        );
        int[][] expected = {
                {1, 2},
                {3, 4},
                {5, 0}
        };
        assertThat(result).isDeepEqualTo(expected);
    }
}