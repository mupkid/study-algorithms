package org.ohx.codinginterviews.question2;

/**
 * 单例模式实现1：懒汉式
 *
 * @author mudkip
 * @date 2022/4/16 14:34
 */
public class Singleton1 {
    private static Singleton1 uniqueInstance;

    private Singleton1() {
    }

    public static synchronized Singleton1 getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton1();
        }
        return uniqueInstance;
    }
}
