package com.springboot.util;

import com.mysql.cj.util.TimeUtil;

/**
 * @author lulu
 * 懒汉模式实现单例
 */
public class SingletonTest {



    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingleton instance = LazySingleton.getInstance();
                System.out.println(instance);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingleton instance = LazySingleton.getInstance();
                System.out.println(instance);

            }
        }).start();

    }

    static class LazySingleton{
        /**
         * 单例属性
         */
        private static volatile LazySingleton instance;

        /**
         * 构造函数私有化
         */
        private LazySingleton(){

        }

        /**
         * 单例方法
         * @return x
         */
        public static LazySingleton getInstance(){
            if(instance == null){
                synchronized (LazySingleton.class){
                    if (instance == null){
                        instance = new LazySingleton();
                    }
                }
            }
            return instance;
        }

    }



}
