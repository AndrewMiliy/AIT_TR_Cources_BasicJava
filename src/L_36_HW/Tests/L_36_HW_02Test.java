package L_36_HW.Tests;

import org.junit.jupiter.api.Test;
import L_36_HW.L_36_HW_02;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class L_36_HW_02Test {

    @Test
    public void testBasicInput() {
        Integer[] integers = {1, 6, 5, 4, 7, 8, 9, 2, 7, 3};
        Integer[] expected = {2, 4, 6, 8, 9, 7, 7, 5, 3, 1};
        Arrays.sort(integers, new L_36_HW_02.MyComparator2());
        assertArrayEquals(expected, integers);
    }

    @Test
    public void testAllOdd() {
        Integer[] integers = {3, 5, 7, 9, 11};
        Integer[] expected = {11, 9, 7, 5, 3};
        Arrays.sort(integers, new L_36_HW_02.MyComparator2());
        assertArrayEquals(expected, integers);
    }

    @Test
    public void testAllEven() {
        Integer[] integers = {2, 4, 6, 8, 10};
        Integer[] expected = {2, 4, 6, 8, 10};
        Arrays.sort(integers, new L_36_HW_02.MyComparator2());
        assertArrayEquals(expected, integers);
    }

    @Test
    public void testMixed() {
        Integer[] integers = {5, 2, 8, 1, 7};
        Integer[] expected = {2, 8, 7, 5, 1};
        Arrays.sort(integers, new L_36_HW_02.MyComparator2());
        assertArrayEquals(expected, integers);
    }

    @Test
    public void testSingleElement() {
        Integer[] integers = {5};
        Integer[] expected = {5};
        Arrays.sort(integers, new L_36_HW_02.MyComparator2());
        assertArrayEquals(expected, integers);
    }

    @Test
    public void testEmptyArray() {
        Integer[] integers = {};
        Integer[] expected = {};
        Arrays.sort(integers, new L_36_HW_02.MyComparator2());
        assertArrayEquals(expected, integers);
    }
}