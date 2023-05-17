package javasrc.contest.biweekly99;

/*
 * @Created ${MONTH}/${DAY}/${YEAR} - ${TIME}
 * @Author ${USER}
 *
 */
public class ColoredCells {
    public static void main(String[] args) {


        System.out.println(coloredCells(3));
    }

    public static long coloredCells(int n) {
        if (n == 1) {
            return 1;
        } else {
            long res = 4*(n-1) + coloredCells(n-1);
            return res;
        }
    }
}