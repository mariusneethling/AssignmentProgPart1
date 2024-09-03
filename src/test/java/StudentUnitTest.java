
import com.mycompany.prjstudentapp.PrjStudentApp;
import com.mycompany.prjstudentapp.Student;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;






public class StudentUnitTest 
{
    
   @Test
    public void testSaveStudent() 
    {
        // Creating and adding a new student to the array list
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
        PrjStudentApp.students.add(student);
        
        // Testing to see if the student was successfully added to the array list
        assertEquals(1, PrjStudentApp.students.size());
        assertEquals("J.Bloggs", PrjStudentApp.students.get(0).getName());
        assertEquals(19, PrjStudentApp.students.get(0).getAge());
    }

    @Test
    public void testSearchStudent() 
    {
        // Creating and adding a new student to search for in the array list
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
        PrjStudentApp.students.add(student);
        
        // Searching for the student by their ID
        Student foundStudent = PrjStudentApp.searchStudentId("10111");
        
        //Testing to see if the student was found in the array list
        assertNotNull(foundStudent);
        assertEquals("10111", foundStudent.getId());
    }

    @Test
    public void testSearchStudent_StudentNotFound() 
    {
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
        // Searching for a student with an incorrect ID or a non-existing ID
        Student foundStudent = PrjStudentApp.searchStudentId("420420");
        
        // Testing to see if the student wasn't found
        assertNull(foundStudent);
    }

    @Test
    public void testDeleteStudent() 
    {
        // Adding a new student to be delete by their ID
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
        PrjStudentApp.students.add(student);
        
        // Deleting the newly added student
        boolean wasDeleted = PrjStudentApp.deleteStudentId("10111");
        
        // Testing to see if the student was successfully deleted
        assertTrue(wasDeleted);
        assertEquals(0, PrjStudentApp.students.size());
    }

    @Test
    public void testDeleteStudent_StudentNotFound() 
    {
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
        // Attempting to delete a student that doesn't exist in the array list
        boolean wasDeleted = PrjStudentApp.deleteStudentId("420420");
        
        // Testing to see if no students were deleted
        assertFalse(wasDeleted);
    }

    @Test
    public void testStudentAge_StudentAgeValid() 
    {
        // Testing to see if the age is at least 16
        assertTrue(PrjStudentApp.isValidAge(21));
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() 
    {
        // Testing to see if the age is lower than 16
        assertFalse(PrjStudentApp.isValidAge(13));
    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() 
    {
        try 
        {
            // Testing to see if the user entered invalid data types 
            PrjStudentApp.parseAge("Johnny");
            fail("Expected NumberFormatException for non-numeric input");
        } 
        //Robertson, E. What is the proper way to handle a NumberFormatException when it is expected?
        catch (NumberFormatException e)
        {
            
        }
    }
    
    
   
    
   
}
