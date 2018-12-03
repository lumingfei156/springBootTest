package com.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lulu
 * @since 2018/12/03
 * 通过配置文件生成bean
 */
@ConfigurationProperties(prefix = "com.bean")
public class ConfigBean {
    private String name;
    private String sex;
    private String concat;
    private String srecte;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getConcat() {
        return concat;
    }

    public void setConcat(String concat) {
        this.concat = concat;
    }

    public String getSrecte() {
        return srecte;
    }

    public void setSrecte(String srecte) {
        this.srecte = srecte;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
