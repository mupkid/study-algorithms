package org.ohx.codinginterviews.question2;

/**
 * 单例模式实现3：双重校验锁
 *
 * @author mudkip
 * @date 2022/4/16 14:40
 */
public class Singleton3 {
    /**
     * volatile确保：当uniqueInstance变量被初始化时，多个线程正确处理uniqueInstance变量
     */
    private volatile static Singleton3 uniqueInstance;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (uniqueInstance == null) {
            // 只有第一次才彻底执行这里的代码
            synchronized (Singleton3.class) {
                // 进入区块后，再检查一次，如果仍是null，才创建实例
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton3();
                }
            }
        }
        return uniqueInstance;
    }
}
