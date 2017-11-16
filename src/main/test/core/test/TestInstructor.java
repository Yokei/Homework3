package core.test;
 
import core.api.IInstructor;
import core.api.impl.Instructor;
import core.api.IAdmin;
import core.api.impl.Admin;
import core.api.IStudent;
import core.api.impl.Student;
import org.junit.Before;
import org.junit.Test;
 
import static org.junit.Assert.*;
 
public class TestInstructor {
 
    private IAdmin admin;
    private IStudent student;
    private IInstructor instructor;

 
    @Before
    public void setup() {
        this.admin = new Admin();
        this.student = new Student();
        this.instructor = new Instructor();
    }
 
    @Test
    public void validHomework() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        assertTrue(this.admin.classExists("Test", 2017));
        this.instructor.addHomework("Instructor", "Test", 2017, "HW");
        assertTrue(this.instructor.homeworkExists("Test", 2017, "HW"));
    }
   
    @Test
    public void addEmptyInstructorHW() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        assertTrue(this.admin.classExists("Test", 2017));
        this.instructor.addHomework("", "Test", 2017, "HW");
        assertFalse(this.instructor.homeworkExists("Test", 2017, "HW"));
    }
    
    @Test
    public void addHNoClassHW() {
        assertFalse(this.admin.classExists("Test", 2017));
        this.instructor.addHomework("Instructor", "Test", 2017, "HW");
        assertFalse(this.instructor.homeworkExists("Test", 2017, "HW"));
    }
    
    @Test
    public void addPastHomework() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        assertTrue(this.admin.classExists("Test", 2017));
        this.instructor.addHomework("Instructor", "Test", 2011, "HW");
        assertFalse(this.instructor.homeworkExists("Test", 2011, "HW"));
    }
   
    @Test
    public void addEmptyNameHW() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        assertTrue(this.admin.classExists("Test", 2017));
        this.instructor.addHomework("Instructor", "Test", 2017, "");
        assertFalse(this.instructor.homeworkExists("Test", 2017, ""));
    }
    
   

   
   
}