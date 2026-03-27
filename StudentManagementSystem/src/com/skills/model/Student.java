package com.skills.model;

public class Student {

    private int id;
    private String name;
    private double marks;
    private int rollNum;
    private String courseEnrolled;

    public Student(int id, String name, double marks, int rollNum, String courseEnrolled) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rollNum = rollNum;
        this.courseEnrolled = courseEnrolled;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }
    public int getRollNum() { return rollNum; }
    public String getCourseEnrolled() { return courseEnrolled; }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Marks: " + marks +
                ", Roll: " + rollNum +
                ", Course: " + courseEnrolled;
    }
}