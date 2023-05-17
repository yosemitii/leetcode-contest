package javasrc.cubistoa;
/*
 * @Created 05/17/2023 - 12:16 PM
 * @Author sun
 * @Info: Q2578 Split with minimum sum
 */

import java.util.*;

public class SplitNum {
    static int sum = Integer.MAX_VALUE;
    static String numStr;
    static int len;
    static ArrayList<Integer> indecies;

    public static int splitNum(int num) {
        numStr = Integer.toString(num);
        len = numStr.length();
        LinkedList<Integer> index = new LinkedList();
        backtrack(0, index, len / 2);
        int res = sum;
        sum = Integer.MAX_VALUE;
        return res;
    }

    public static int makeMinInt(String s, List<Integer> index) {
        String res = "";
        Integer[] nums = new Integer[index.size()];
        int j = 0;

        for(Iterator var5 = index.iterator(); var5.hasNext(); ++j) {
            Integer i = (Integer)var5.next();
            nums[j] = Integer.parseInt(s.substring(i, i + 1));
        }

        Arrays.sort(nums);
        Integer[] var9 = nums;
        int var10 = nums.length;

        for(int var7 = 0; var7 < var10; ++var7) {
            Integer i = var9[var7];
            res = res + Integer.toString(i);
        }

        return Integer.parseInt(res);
    }

    public static void backtrack(int start, LinkedList<Integer> index, int targetLen) {
        int num1;
        if (index.size() == targetLen) {
            num1 = makeMinInt(numStr, index);
            ArrayList<Integer> num2Index = new ArrayList();

            for(Integer i = 0; i < len; i = i + 1) {
                if (!index.contains(i)) {
                    num2Index.add(i);
                }
            }

            int num2 = makeMinInt(numStr, num2Index);
            if (sum > num1 + num2) {
                sum = num1 + num2;
            }
        }

        for(num1 = start; num1 < len; ++num1) {
            index.add(num1);
            backtrack(num1 + 1, index, targetLen);
            index.removeLast();
        }

    }
}
