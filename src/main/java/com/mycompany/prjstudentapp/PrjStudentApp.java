

package com.mycompany.prjstudentapp;
import java.util.ArrayList;
import java.util.Scanner;

public class PrjStudentApp 
{

     //Declaring an arraylist for the students
    public static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    //Main method
    public static void main(String[] args) 
    {
        //Using a while loop to run the display menu until the user wishes to exit
        while (true) 
        {
            displayMainMenu();
            String choice = scanner.nextLine();

            if (choice.equals("1")) 
            {
                displayMenu();
            } 
            else 
            {
                System.out.println("Exiting Application...");
                break;
            }
        }
    }

    // Method to display the main menu
    public static void displayMainMenu() 
    {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("**********************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
    }

    // Method to display the options menu to the user
    public static void displayMenu() 
    {
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new student.");
        System.out.println("(2) Search for a student.");
        System.out.println("(3) Delete a student.");
        System.out.println("(4) Print student report.");
        System.out.println("(5) Exit Application.");

        String choice = scanner.nextLine();

        //using a switch to call on and execute different methods depending on what the user wants to do
        switch (choice) 
        {
            case "1":
                SaveStudent();
                break;
            case "2":
                searchStudent();
                break;
            case "3":
                deleteStudent();
                break;
            case "4":
                displayStudentReport();
                break;
            case "5":
                System.out.println("Exiting Application...");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // Method to capture and add a new student to the array list
    public static void SaveStudent() 
    {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("*************************");

        System.out.print("Enter the student id: ");
        String id = scanner.nextLine();

        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        //Calling onto the getValidAge method to get the age of the student and ensure it meets the requirements
        int age = getValidAge();

        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        //adding the new student details to the array list
        students.add(new Student(id, name, age, email, course));
        System.out.println("Student successfully captured!");

        exitStudentapplication();
    }

    // Method to prompt the user for the students age and passing the value to the boolean method to execute and ensure the age is at least 16
    public static int getValidAge() 
    {
        while (true) 
        {
            System.out.print("Enter the student age: ");
            String ageOfStudent = scanner.nextLine();
            try 
            {
                //parsing the string age the user inputted to an integer
                int age = Integer.parseInt(ageOfStudent);
                
                if (isValidAge(age)) 
                {
                    return age;
                } 
                else 
                {
                    System.out.println("You have entered an incorrect student age! Age must be 16 or older.");
                }
            } 
            //Using a NumberFormatException in case the user inputs a value that can't be parsed into an integer
            //Robertson, E. What is the proper way to handle a NumberFormatException when it is expected?
            catch (NumberFormatException e) 
            {
                System.out.println("You have entered an incorrect student age! Only numbers are allowed.");
            }
        }
    }

    // Boolean method to check if the student's age is at least 16
    public static boolean isValidAge(int age) 
    {
        return age >= 16;
    }

    // Method to parse the age input from the user
    public static int parseAge(String studentAge) 
    {
        return Integer.parseInt(studentAge);
    }

    // Method to search for a student by their respective ID
    public static Student searchStudentId(String id) 
    {
        //using a for loop to run through the array list and check if the student's id matches one in the array list
        for (Student student : students) 
        {
            if (student.getId().equals(id)) 
            {
                return student;
            }
        }
        return null;
    }

    // Method to search and display a student by calling onto the above method
    public static void searchStudent() 
    {
        System.out.print("Enter the student id to search: ");
        //getting the id from the user
        String id = scanner.nextLine();
        Student foundStudent = searchStudentId(id);
        
        if (foundStudent != null) 
        {
            System.out.println(foundStudent.displayStudent());
        } 
        else 
        {
            System.out.println("Student with Student Id: " + id + " was not found!");
        }
        exitStudentapplication();
    }

    // Method to search and delete a student by their ID
    public static boolean deleteStudentId(String id) 
    {
        Student studentToBeDeleted = null;
        
        //for loop to run through the array list and check if the student id exists
        for (Student student : students) 
        {
            if (student.getId().equals(id)) 
            {
                studentToBeDeleted = student;
                break;
            }
        }
        
        //deleting the student if their id was found in the array list
        if (studentToBeDeleted != null) 
        {
            students.remove(studentToBeDeleted);
            return true;
        } 
        else 
        {
            return false;
        }
    }

    // Method to get input from the user and display if the student was deleted or not found
    public static void deleteStudent() 
    {
        System.out.print("Enter the student id to delete: ");
        String id = scanner.nextLine();
        
        if (deleteStudentId(id)) 
        {
            System.out.println("Student with Student Id: " + id + " was deleted!");
        } 
        else 
        {
            System.out.println("Student with Student Id: " + id + " was not found!");
        }
        exitStudentapplication();
    }

    // Method to display all the student reports
    public static void displayStudentReport() 
    {
        System.out.println("STUDENT REPORT");
        System.out.println("**********************************");
        
        //for loop to run through the array and display all the students with their details
        for (Student student : students) 
        {
            System.out.println(student.displayStudent());
            System.out.println("----------------------------------");
        }
        exitStudentapplication();
    }

    //Method to exit and return to the main menu of the application 
    public static void exitStudentapplication() 
    {
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String choice = scanner.nextLine();
        
        if (!choice.equals("1")) 
        {
            System.out.println("Exiting Application...");
            System.exit(0);
        }
    }
}
/*
Reference List:
    1. Robertson, E. 2010. NumberFormatException. (Version 1.0- SNAPSHOT)
        https://stackoverflow.com/questions/4410107/what-is-the-proper-way-to-handle-a-numberformatexception-when-it-is-expected (Accessed 29 August 2024)
        
    2. Farrel, J. 2023. Java Programming 9th Edition Cengage. 
         
*/