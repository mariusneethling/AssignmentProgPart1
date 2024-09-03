
package com.mycompany.prjstudentapp;


public class Student 
{
    //declaring variables to store the students' details
   private String id;
    private String name;
    private int age;
    private String email;
    private String course;

    
    public Student(String id, String name, int age, String email, String course) 
    {
        //setting the student's details
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getter methods for the students details
    public String getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public int getAge() 
    {
        return age;
    }

    public String getEmail() 
    {
        return email;
    }

    public String getCourse() 
    {
        return course;
    }

    // Displaying all the students' details
    public String displayStudent() 
    {
        return "STUDENT ID: " + id + "\nSTUDENT NAME: " + name + "\nSTUDENT AGE: " + age + "\nSTUDENT EMAIL: " + email + "\nSTUDENT COURSE: " + course;
    }  
}
