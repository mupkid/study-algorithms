package mianshizhinan.chapter1;

import java.util.Stack;

/**
 * 一个不含负数的数组可以代表一圈环形山，每个位置的值代表山的高度，返回有多少对山峰能够互相看见
 */
public class VisibleMountain {

    /**
     * 给定一个不含有负数且没有重复值得数组
     *
     * @param arr
     * @return
     */
    public int getVisibleNumNoRepeat(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        } else if (arr.length == 2) {
            return 1;
        } else {
            return 2 * arr.length - 3;
        }
    }

    /**
     * 给定一个不含有负数但可能含有重复值的数组
     *
     * @param arr
     * @return
     */
    public int getVisibleNum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int size = arr.length;
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        Stack<Record> stack = new Stack<>();
        //先把（最大值，1）这个记录放入栈中
        stack.push(new Record(arr[maxIndex]));
        //从最大值位置的下一个位置开始沿next方向遍历
        int index = nextIndex(maxIndex, size);
        //用“小找大”的方法统计所有可见山峰对
        int res = 0;
        //遍历阶段开始，当index再次回到maxIndex
        while (index != maxIndex) {
            //当前数字arr[index]要进栈，判断会不会破坏第一维的数字从顶到底依次变大
            //如果破坏了，就依次弹出栈顶记录，并计算山峰对数量
            while (stack.peek().value < arr[index]) {
                int k = stack.pop().times;
                //弹出记录为（X,K)，如果K==1，产生两对
                //如果K>1，产生2*K+C(2,K)对
                res += getInternalSum(k) + 2 * k;
            }
            //当前数字arr[index]要进栈了，如果和当前栈顶数字一样就合并
            //不一样就把记录（arr[index],1)放入栈中
            if (stack.peek().value == arr[index]) {
                stack.peek().times++;
            } else {
                stack.push(new Record(arr[index]));
            }
            index = nextIndex(index, size);
        }
        //清算阶段开始
        //清算阶段的第1小阶段
        while (stack.size() > 2) {
            int times = stack.pop().times;
            res += getInternalSum(times) + 2 * times;
        }
        //清算阶段的第2小阶段
        if (stack.size() == 2) {
            int times = stack.pop().times;
            res += getInternalSum(times) + (stack.peek().times == 1 ? times : 2 * times);
        }
        //清算阶段的第3小阶段
        res += getInternalSum(stack.pop().times);
        return res;
    }

    /**
     * 如果k==1,返回0,；如果k>1，返回C(2,K)
     *
     * @param k
     * @return
     */
    public int getInternalSum(int k) {
        return k == 1 ? 0 : (k * (k - 1) / 2);
    }

    /**
     * 环形数组中当前位置为i，数组长度为size，返回i的一下个位置
     *
     * @param i
     * @param size
     * @return
     */
    public int nextIndex(int i, int size) {
        return i < (size - 1) ? (i + 1) : 0;
    }

    private class Record {
        int value;
        int times;

        Record(int value) {
            this.value = value;
            this.times = 1;
        }
    }
}
