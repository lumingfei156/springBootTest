package com.springboot.util;

/**
 * @author lulu
 * 利用类加载机制实现的懒汉单例模式
 */
public class InnerClassSingleton {
    /**
     * 私有化构造函数
     */
    private InnerClassSingleton(){

    }

    public static InnerClassSingleton getInstance(){
        return Singleton.instance;
    }

    static class Singleton{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }


}
