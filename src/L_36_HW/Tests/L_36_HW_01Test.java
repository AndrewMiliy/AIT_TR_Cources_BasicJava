package L_36_HW.Tests;

import L_36_HW.L_36_HW_01;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class L_36_HW_01Test {

    @Test
    public void testBasicInput() {
        Integer[] integers = {1, 6, 5, 4, 7, 8, 9, 2, 7, 3};
        Integer[] expected = {2, 4, 6, 8, 1, 3, 5, 7, 7, 9};
        Arrays.sort(integers, new L_36_HW_01.MyComparator1());
        assertArrayEquals(expected, integers);
    }

    @Test
    public void testAllOdd() {
        Integer[] integers = {3, 5, 7, 9, 11};
        Integer[] expected = {3, 5, 7, 9, 11};
        Arrays.sort(integers, new L_36_HW_01.MyComparator1());
        assertArrayEquals(expected, integers);
    }

    @Test
    public void testAllEven() {
        Integer[] integers = {2, 4, 6, 8, 10};
        Integer[] expected = {2, 4, 6, 8, 10};
        Arrays.sort(integers, new L_36_HW_01.MyComparator1());
        assertArrayEquals(expected, integers);
    }

    @Test
    public void testSingleElement() {
        Integer[] integers = {5};
        Integer[] expected = {5};
        Arrays.sort(integers, new L_36_HW_01.MyComparator1());
        assertArrayEquals(expected, integers);
    }

    @Test
    public void testEmptyArray() {
        Integer[] integers = {};
        Integer[] expected = {};
        Arrays.sort(integers, new L_36_HW_01.MyComparator1());
        assertArrayEquals(expected, integers);
    }

}