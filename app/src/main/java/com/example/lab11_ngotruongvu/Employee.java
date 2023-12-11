package com.example.lab11_ngotruongvu;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
public class Employee {
    private String id;
    private String name;
    private int age;

    public Employee() {}

    public Employee(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Override
    public String toString() {
        return this.name;
    }
}
