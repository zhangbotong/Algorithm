import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Kyrie
 * @date 2022/8/19 09:41
 */
public class UglyNumber {
    public static void main(String[] args) {
        String s = "abc";
        char[] chars = s.toCharArray();
        int a = 1;
        HashMap<String, String> map = new HashMap<>();
//        int a = 4;
//        int b = 6;
//        System.out.println(nthUglyNumber(10));
//        System.out.println(isUgly(12));
    }

    static void test (){
        List l = new ArrayList();
        for (int i = 0; i < 20; i++){
            System.out.println(String.format("size: %s", l.size()));
            l.add(i);
        }
    }

    /**
     * 判断一个数是不是丑数
     */
    public static boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    /**
     * 求第n个丑数
     * @param n
     * @return
     */
    static int nthUglyNumber (int n) {
        if (n <= 0) {
            return 0;
        }
        int[] ugly = new int[n];
        ugly[0] = 1;
        // i2, i3, i5 must be less than i
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
            if (ugly[i] == ugly[i2] * 2) {
                i2++;
            }
            if (ugly[i] == ugly[i3] * 3) {
                i3++;
            }
            if (ugly[i] == ugly[i5] * 5) {
                i5++;
            }
        }
        return ugly[n - 1];
    }

    // TODO super ugly number
    /**
     * 求第n个超丑数
     */
    static int nthSuperUglyNumber (int n) {
        if (n <= 0) {
            return 0;
        }
        int[] ugly = new int[n];
        ugly[0] = 1;
        // i2, i3, i5 must be less than i
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
            if (ugly[i] == ugly[i2] * 2) {
                i2++;
            }
            if (ugly[i] == ugly[i3] * 3) {
                i3++;
            }
            if (ugly[i] == ugly[i5] * 5) {
                i5++;
            }
        }
        return ugly[n - 1];
    }
}
