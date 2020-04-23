package com.springboot.util;

/**
 * @author lulu
 * 通过枚举类型实现单例
 */
public enum EnumSignleton {
    /**
     * 单例1
     */
    INSTANCE;

    public void print(){
        System.out.println(this.hashCode());
    }

}
