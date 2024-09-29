package lab;

import java.util.ArrayList;
import java.util.List;

public class Sorting {
    public static int[] toString (int[] nums) {
        int[] result = new int[nums.length];
        List<Integer> box = new ArrayList<>();
        for(int i : nums) {
            box.add(i);
        }
        box.sort(null);
        for (int i = 0; i < nums.length; i++) {
            result[i] = box.get(i);
        }
        return result;
    }

}
