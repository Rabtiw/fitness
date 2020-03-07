package com.example.mahe.fitness;

/**
 * Created by MAHE on 02-Mar-20.
 */

public class Member {
    private String name;
    private  Integer age;
    private  String gender;
    private  String email;
    private Long phno;
    private String location;
    private Integer calories;

    public Member() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhno() {
        return phno;
    }

    public void setPhno(Long phno) {
        this.phno = phno;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public Integer getCalories() {return calories;}

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    }
