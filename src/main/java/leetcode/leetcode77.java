package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode77 {


    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * <p>
     * 你可以按 任何顺序 返回答案。
     * <p>
     * 输入：n = 4, k = 2
     * 输出：
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     *
     * @param args
     */

    //一维数组path路径
    private static List<Integer> path = new ArrayList<>();
    //二维数组result
    private static List<List<Integer>> result = new ArrayList<>();


    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        dsf(n, k, 1);
        System.out.println(result);
    }


    /**
     * 递归
     *
     * @param n
     * @param k
     * @param startIndex
     */
    private static void dsf(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            dsf(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }


}