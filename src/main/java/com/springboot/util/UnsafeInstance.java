package com.springboot.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author lulu
 * 实例化Unsafe对象
 */
public class UnsafeInstance {

    /**
     * 获取Unsafe对象
     * @return x
     */
    public static Unsafe reflectGetUnsafe(){
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }



}
