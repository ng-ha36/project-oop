package Student;

import java.util.List;
import java.util.Scanner;

public class Student {
    public static Scanner scanner = new Scanner(System.in);

    static List<Student> studentList;

    int id;
    String studentName;
    int hocKy;
    String courseName;

    public Student() {
    }

    public Student(int id, String studentName, int hocKy, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.hocKy = hocKy;
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void displayInfor() {
        System.out.println("Id: " + getId() + ", Ten: " + getStudentName() + ", hoc ky: " + getHocKy() + ", Khoa hoc: " + getCourseName());
        System.out.println();
    }
}