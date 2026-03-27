package studentmanagement;

public class Student {
    private int id;
    private String name;
    private double marks;
    private int rollNum;
    private String courseEnrolled;

    // Constructor
    public Student(int id, String name, double marks, int rollNum, String courseEnrolled) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rollNum = rollNum;
        this.courseEnrolled = courseEnrolled;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public int getRollNum() {
        return rollNum;
    }

    public String getCourseEnrolled() {
        return courseEnrolled;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public void setCourseEnrolled(String courseEnrolled) {
        this.courseEnrolled = courseEnrolled;
    }

    // toString method
    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Marks: " + marks +
                ", Roll No: " + rollNum +
                ", Course: " + courseEnrolled;
    }
}