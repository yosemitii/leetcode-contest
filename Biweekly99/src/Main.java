import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @Created ${MONTH}/${DAY}/${YEAR} - ${TIME}
 * @Author ${USER}
 *
 */
public class Main {

    static int sum = Integer.MAX_VALUE;
    static String numStr;
    static int len;
    static ArrayList<Integer> indecies;
    public static void main(String[] args) {
//        System.out.println(splitNum(4325));

        System.out.println(splitNum(687));

//        System.out.println("Hello world!");
    }

    public static int splitNum(int num) {
        numStr = Integer.toString(num);
        len = numStr.length();
        LinkedList<Integer> index = new LinkedList<>();
        backtrack(0, index, len/2);
        int res = sum;
        sum = Integer.MAX_VALUE;
        return res;
    }

    public static int makeMinInt(String s, List<Integer> index){
        String res = "";
        Integer[] nums = new Integer[index.size()];
        int j = 0;
        for (Integer i: index) {
            nums[j] = Integer.parseInt(s.substring(i, i+1));
            j++;
        }
        Arrays.sort(nums);
        for (Integer i: nums) {
            res += Integer.toString(i);
        }
        return Integer.parseInt(res);
    }

    public static void backtrack(int start, LinkedList<Integer> index, int targetLen){
        if (index.size() == targetLen) {
            int num1 = makeMinInt(numStr, index);
            ArrayList<Integer> num2Index = new ArrayList<>();
            for (Integer i = 0; i < len; i++) {
                if (!index.contains(i)) {
                    num2Index.add(i);
                }
            }
            int num2 = makeMinInt(numStr, num2Index);
            if (sum > num1 + num2) {
                sum = num1 + num2;
            }
        }

        for (int i = start; i < len; i++) {
            index.add(i);
            backtrack(i+1, index, targetLen);
            index.removeLast();
        }
    }
}