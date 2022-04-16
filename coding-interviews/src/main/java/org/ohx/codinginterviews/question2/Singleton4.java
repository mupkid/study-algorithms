package org.ohx.codinginterviews.question2;

/**
 * 单例模式实现4：登记式
 *
 * @author mudkip
 * @date 2022/4/16 14:42
 */
public class Singleton4 {
    private static class SingletonHolder {
        private static final Singleton4 UNIQUE_INSTANCE = new Singleton4();
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.UNIQUE_INSTANCE;
    }
}
