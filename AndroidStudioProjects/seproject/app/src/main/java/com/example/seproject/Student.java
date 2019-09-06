package com.example.seproject;

import java.util.ArrayList;
import java.util.HashMap;

public class Student
{
    public String project;
    public String name;
    public String id;


    static ArrayList<Student> arr = new ArrayList<>(10);

    public Student()
    {

    }

    public Student(String project, String name,String id)
    {
        this.project = project;
        this.name = name;
        this.id = id;

        arr.add(this);

    }

    public String getProject() {
        return project;
    }

    public String getName() {
        return name;
    }
    public String getId()
    {
        return id;
    }
}
