package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode39 {

    // 二维数组result
    private static List<List<Integer>> result = new ArrayList<>();

    // 一维数组path路径
    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        dsf(candidates, target, 0);
        System.out.println(result);
    }


    private static void dsf(int[] candidates, int target, int startIndex) {
        Integer sum = path.stream().mapToInt(Integer::intValue).sum();
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            dsf(candidates, target, i);
            path.remove(path.size() - 1);
        }
    }

}