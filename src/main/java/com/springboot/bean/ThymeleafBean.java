package com.springboot.bean;
/**
 * @author lulu
 * @since 2018/12/04
 * 用于用于进行Thymeleaf测试
 */
public class ThymeleafBean {
    private String author;
    private String articleName;
    private String url;

    public ThymeleafBean(){}

    public ThymeleafBean(String author,String articleName,String url){
        this.author = author;
        this.articleName = articleName;
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
