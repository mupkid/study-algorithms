package org.ohx.codinginterviews.question2;

/**
 * 单例模式实现2：饿汉式
 *
 * @author mudkip
 * @date 2022/4/16 14:38
 */
public class Singleton2 {
    private static final Singleton2 UNIQUE_INSTANCE = new Singleton2();

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        return UNIQUE_INSTANCE;
    }
}
