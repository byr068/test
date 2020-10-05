package com.company.json;

import java.util.List;

public class user {
    private String name;
    private int age;
    private List<Goods> goodList;

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Goods> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Goods> goodList) {
        this.goodList = goodList;
    }
}
