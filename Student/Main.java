package Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Student> studentList;
    static int count = 0;
    static int id;
    static String studentName;
    static int hocKy;
    static String courseName;
    
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        studentList = new ArrayList<>();

        boolean thoat = false;
        int luaChon;
    
        do {
            
            showMenu();
            System.out.println("Lua chon: ");
            luaChon = Integer.parseInt(scanner.nextLine());

            switch(luaChon) {
                case 1 :
                    tao();
                    break;
                case 2 :
                    search();
                    System.out.println();
                    System.out.println("Sap xep ho ten sinh vien theo thu tu");
                    System.out.println();
                    sapXep();

                    break;
                case 3 :
                    capNhat();
                    break;
                case 4 :
                    baoCao();
                    break;
                case 5 :
                    System.out.println("Thoat");
                    thoat = true;
                    break;

                default :
                    System.out.println("Vui long chon lai!");
                    break;
            }
        } while (luaChon != 5);
    }

    public static void showMenu() {
        System.out.println("CHAO MUNG DEN QUAN LY SINH VIEN");
        System.out.println();
        System.out.println("    1.Tao");
        System.out.println("    2.Tim kiem va Sap xep");
        System.out.println("    3.Cap nhat/Xoa");
        System.out.println("    4.Bao cao");
        System.out.println("    5.Thoat");
        System.out.println();
        System.out.println("Chon 1 de Tao, 2 de Tim kiem va Sap xep, 3 de Cap nhat/Xoa, 4 de Bao cao va 5 de Thoat");
    } 

    public static void tao() {
        
        do {
            System.out.print("Nhap ma so: ");
            id = Integer.parseInt(scanner.nextLine());
    
            System.out.print("Nhap ho ten: ");
            studentName = scanner.nextLine();
    
            System.out.print("Nhap hoc ky: ");
            hocKy = Integer.parseInt(scanner.nextLine());
            
            List<String> listCourse = Arrays.asList("Java", ".Net", "C/C++");
            do {
                System.out.print("Nh3ap khoa hoc(Java, .Net, C/C++): ");
                courseName = scanner.nextLine();
                System.out.println();

            } while (!listCourse.contains(courseName));
            
            count++;

            if (count > 10) {
                System.out.println("Ban co muon tiep tuc (Y/N) khong?");
                String chon = scanner.nextLine();
                if (chon.equalsIgnoreCase("N")) {
                    break; 
                }
            }
            // Khoi tao doi tuong student 
            Student student = new Student(id, studentName, hocKy, courseName);
            // them student va studentList
            studentList.add(student);
        } while (true);
    }

    public static void search() {
        System.out.println("Nhap tim kiem thong tin: ");
        String thongTin = scanner.nextLine();

        boolean flat = false;
        for (Student student : studentList) {
            if (student.getStudentName().contains(thongTin)) {
                flat = true;
                student.displayInfor();
            } 
        }
        if (flat == false) {
            System.out.println("Khong tim thay thong tin");
        }
    }

    public static void sapXep() {
        Collections.sort(studentList, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        });
        // Hien thi thong tin
        for (Student student : studentList) {
            student.displayInfor();
        }
    }

    public static void capNhat() {
        System.out.println("Nhap id cua sinh vien can tim kiem: ");
        int searchId = Integer.parseInt( scanner.nextLine());
        Student studentFound = null;

        for (Student student : studentList) {
            if (student.getId() == searchId) {
                studentFound = student;
            }
        }
        System.out.print("Ban muon cap nhat(U) hay xoa(D) hoc sinh: ");
        String chon = scanner.nextLine();
        if (chon.equalsIgnoreCase("U")) {
            System.out.print("Ten cap nhat moi: ");
            String name = scanner.nextLine();
            studentFound.setStudentName(name);

            System.out.print("Ky hoc cap nhat moi: ");
            int kyHoc = Integer.parseInt(scanner.nextLine());
            studentFound.setHocKy(kyHoc);

            System.out.print("Khoa hoc cap nhat moi: ");
            String course = scanner.nextLine();
            studentFound.setCourseName(course);

        } else {
            studentList.remove(studentFound);
        }
        System.out.println("Thong tin sinh vien sau khi cap nhat/xoa");
        for (Student student : studentList) {
            student.displayInfor();
        }
    }

    public static void baoCao() {
       
        for (Student student : studentList) {
            System.out.println(student.getStudentName() + " | " + student.getCourseName());
        }
    }
}
