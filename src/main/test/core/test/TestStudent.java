package core.test;
import core.api.IInstructor;
import core.api.impl.Instructor;
import core.api.impl.Admin;
import core.api.IStudent;
import core.api.impl.Student;
import org.junit.Before;
import org.junit.Test;
import core.api.IAdmin;
import static org.junit.Assert.*;

public class TestStudent {
 
    private IInstructor instructor;
    private IAdmin admin;
    private IStudent student;
 
    @Before
    public void setup() {
        this.instructor = new Instructor();
        this.admin = new Admin();
        this.student = new Student();
    }
   
    @Test
    public void registerValidClass() {
        this.admin.createClass("Test", 2017, "Instructor", 20);
        this.student.registerForClass("Student", "Test", 2017);
        assertTrue(this.student.isRegisteredFor("Student", "Test", 2017));      
    }
   
   
    @Test
    public void registerForFutureClass() {
        this.admin.createClass("Test", 2022, "Instructor", 20);
        this.student.registerForClass("Student", "Test", 2022);
        assertFalse(this.student.isRegisteredFor("Student", "Test", 2022));    
    }
   
    
    @Test
    public void registerForNonExistedClass() {
        this.student.registerForClass("Student", "Test", 2017);
        assertFalse(this.student.isRegisteredFor("Student", "Test", 2017));
    }
    
    @Test
    public void dropingClassWorks() {
        this.admin.createClass("Test", 2017, "Instructor", 20);
        this.student.registerForClass("Student", "Test", 2017);
        assertTrue(this.student.isRegisteredFor("Student", "Test", 2017));
        
        this.student.dropClass("Student", "Test", 2017);
        assertFalse(this.student.isRegisteredFor("Student", "Test", 2017));
    }
    
    @Test
    public void registerEmptyStudentName() {
        this.admin.createClass("Test", 2017, "Instructor", 20);
        this.student.registerForClass("", "Test", 2017);
        assertFalse(this.student.isRegisteredFor("Student", "Test", 2017));    
    }
   
    
    @Test
    public void dropNotRegistedClass() {
        this.admin.createClass("Test", 2017, "Instructor", 20);
        this.student.dropClass("Student", "Test", 2017);
        assertFalse(this.student.isRegisteredFor("Student", "Test", 2017));
    }

}