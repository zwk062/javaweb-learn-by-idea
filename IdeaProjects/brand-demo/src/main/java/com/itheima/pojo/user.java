package com.itheima.pojo;

public class user {
    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    //无参构造器

    public user() {
    }

    //有参构造器
    public user(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
