package com.springboot.entity;

/**
 * @author lulu
 * @since 2018/12/06
 * jdbcThy
 */
public class LearnBean {
    private int id;
    private String author;
    private String title;
    private String url;

    public LearnBean(){}

    public LearnBean(String author,String title,String url){
        this.author = author;
        this.title = title;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString(){
        return "[ author : " + this.author + ", " + " title : " + title + ", " + "url : " + this.url + " ]";
    }
}
