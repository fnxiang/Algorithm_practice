package leetcode;
/* 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 */

import java.util.ArrayList;

public class No7 {
    public int reverse(int x) {
        int result = 0;
        int mod = x;
        do {
            mod = x%10;

        }while(mod!=0);

        return result;
    }
}
