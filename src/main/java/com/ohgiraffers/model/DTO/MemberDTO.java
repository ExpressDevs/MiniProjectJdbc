package com.ohgiraffers.model.DTO;

public class MemberDTO {

    private String name;
    private int age;
    private String id;
    private String pwd;
    private int mileage=0;
    public MemberDTO() {
    }

    public MemberDTO(String name, int age, String id, String pwd) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.pwd = pwd;
    }

    public MemberDTO(String name, int age, String id, String pwd, int mileage) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.pwd = pwd;
        this.mileage = mileage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void addMileage(int mileage) {
        this.mileage += mileage;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", mileage=" + mileage +
                '}';
    }
}

