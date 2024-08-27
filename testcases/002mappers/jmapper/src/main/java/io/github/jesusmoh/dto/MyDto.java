package io.github.jesusmoh.dto;

import com.googlecode.jmapper.annotations.JMap;

public class MyDto {
    private String name;
    @JMap
    private int age;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MyDto(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

}
