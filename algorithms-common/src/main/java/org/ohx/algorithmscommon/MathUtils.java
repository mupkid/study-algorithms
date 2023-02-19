package org.ohx.algorithmscommon;

/**
 * @author mudkip
 * @date 2023/2/16
 */
public final class MathUtils {
    public static long pcb(long x, long y) {
//        c 里可以这么写
//        while ((y ^= (x ^= (y ^= (x %= y)))) != 0) {
//        }
//        return x;
        while (y > 0) {
            long temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

    private MathUtils() {
    }
}
