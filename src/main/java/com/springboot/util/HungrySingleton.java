package com.springboot.util;

/**
 * @author lulu
 * 饿汉模式实现单例
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    /**
     * 私有化构造函数
     */
    private HungrySingleton(){

    }

    /**
     * 获取单例接口
     * @return x
     */
    public static HungrySingleton getInstance(){
        return instance;
    }


}
