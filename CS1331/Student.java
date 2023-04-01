/*
 *Creating a student object with the ability to retrieve and set values
 *
 *@author: Hardik Sangwan
 */

import java.util.Scanner;

public class Student{
    //variables - Student's Name, Major, GPA, 3 Courses and GTID
    //scan to read user input,
    //displayString to construct the String for toString,
    //gtCount to create unique GTIDs
    //gpaSet to check if gpa is within acceptable range
    private String name;
    private String major;
    private double gpa;
    private Course course1=new Course(" "," ",0);
    private Course course2=new Course(" "," ",0);
    private Course course3=new Course(" "," ",0);
    private static int gtCount=1;
    private int gtID;
    String displayString;
    Scanner scan = new Scanner(System.in);

    //Contructor 1
    public Student(String name, String major, double gpa){
        this.name=name;
        this.major=major;
        if (gpa<=4 && gpa>=0){
            this.gpa=gpa;
        }
        else {
            int gpaSet =0;
            while (gpaSet==0){
                System.out.println("GPA cannot be " + gpa + ". Please enter a valid GPA");
                gpa=scan.nextDouble();
                if (gpa<=4 && gpa>=0){
                    this.gpa=gpa;
                    gpaSet=1;
                }
            }
        }
        this.gtID=gtCount;
        gtCount++;
    }

    //Contructor 2
    public Student(String name, String major, double gpa, Course course1, Course course2, Course course3){
        this.name=name;
        this.major=major;
        if (gpa<=4 && gpa>=0){
            this.gpa=gpa;
        }
        else {
            int gpaSet =0;
            while (gpaSet==0){
                System.out.println("GPA cannot be " + gpa + ". Please enter a valid GPA");
                gpa=scan.nextDouble();
                if (gpa<=4 && gpa>=0){
                    this.gpa=gpa;
                    gpaSet=1;
                }
            }
        }
        this.course1=course1;
        this.course2=course2;
        this.course3=course3;
        this.gtID=gtCount;
        gtCount++;
    }
    //setter methods
    public void setName(String name){
        this.name=name;
    }
    public void setMajor(String major){
        this.major=major;
    }
    public void setCourse1(Course course1){
        this.course1=course1;
    }
    public void setCourse2(Course course2){
        this.course2=course2;
    }
    public void setCourse3(Course course3){
        this.course3=course3;
    }
    public void setGpa(double gpa){
        if (gpa<=4 && gpa>=0){
            this.gpa=gpa;
        }
        else {
            int gpaSet =0;
            while (gpaSet==0){
                System.out.println("GPA cannot be "+ gpa + ". Please enter a valid GPA");
                gpa=scan.nextDouble();
                if (gpa<=4 && gpa>=0){
                    this.gpa=gpa;
                    gpaSet=1;
                }
            }
        }
    }

    //getter methods
    public String getName(){
        return this.name;
    }
    public String getMajor(){
        return this.major;
    }
    public double getGpa(){
        return this.gpa;
    }
    public Course getCourse1(){
        return this.course1;
    }
    public Course getCourse2(){
        return this.course2;
    }
    public Course getCourse3(){
        return this.course3;
    }
    public int getGtID(){
        return this.gtID;
    }
    //toString method (Checks for user entered values for courses)
    public String toString(){
        displayString = this.name + " [GTID : " + this.gtID + "] is a(n) " + this.major + " major with a " + this.gpa + " gpa.\n";
        if (course1.getName().equals(" ") && course1.getName().equals(" ") && course1.getName().equals(" ")){
        }
        else {
	    displayString = displayString + "\nEnrolled in : \n";
            if (!course1.getName().equals("")){
                displayString = displayString + course1.toString();
            }
            if (!course2.getName().equals("")){
                displayString = displayString + course2.toString();
            }
            if (!course3.getName().equals("")){
                displayString = displayString + course3.toString();
            }
        }
        return displayString;
    }
}
