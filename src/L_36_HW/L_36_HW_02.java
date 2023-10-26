package L_36_HW;

import java.util.Arrays;
import java.util.Comparator;

public class L_36_HW_02 {

    public static void main(String[] args) {
        Integer[] integers = { 1, 6, 5, 4, 7, 8, 9, 2, 7, 3 };

        Arrays.sort(integers, new MyComparator2());

        System.out.println(Arrays.toString(integers));  // [2, 4, 6, 8, 9, 7, 7, 5, 3, 1]
    }

    public static class MyComparator2 implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 % 2 == 0 && o2 % 2 != 0) {
                return -1;
            } else if (o1 % 2 != 0 && o2 % 2 == 0) {
                return 1;
            } else if (o1 % 2 == 0 && o2 % 2 == 0) {
                return o1.compareTo(o2);
            } else {
                return o2.compareTo(o1);
            }
        }
    }
}
