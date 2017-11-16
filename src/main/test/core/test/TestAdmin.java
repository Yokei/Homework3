package core.test;
 
import core.api.IStudent;
import core.api.impl.Instructor;
import core.api.impl.Student;
import core.api.IAdmin;
import core.api.impl.Admin;
import core.api.IInstructor;

 
import org.junit.Before;
import org.junit.Test;
 
import static org.junit.Assert.*;
 
public class TestAdmin {
 
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
    public void cpacity() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        assertTrue(this.admin.classExists("Test", 2017));
        this.admin.changeCapacity("Test", 2017, 19);
        assertTrue(this.admin.getClassCapacity("Test", 2017) == 20);
    }
    
    @Test
    public void creatingClass() {
        this.admin.createClass("Test", 2017, "Instructor", 20);
        assertTrue(this.admin.classExists("Test", 2017));
    }
    
    @Test
    public void classSizeNonNegative() {
        this.admin.createClass("Test", 2017, "Instructor", -20);
        assertFalse(this.admin.classExists("Test", 2017));
    }
   
    @Test
    public void classSizeZero() {
        this.admin.createClass("Test", 2017, "Instructor", 0);
        assertFalse(this.admin.classExists("Test", 2017));
    }
   
    
    @Test
    public void classNegative() {
        this.admin.createClass("Test", -2017, "Instructor", 15);
        assertFalse(this.admin.classExists("Test", -2017));
    }
   
    @Test
    public void dateClassZero() {
        this.admin.createClass("Test", 0, "Instructor", 20);
        assertFalse(this.admin.classExists("Test", 0));
    }
 
    @Test
    public void pastClass() {
        this.admin.createClass("Test", 2011, "Instructor", 15);
        assertFalse(this.admin.classExists("Test", 2011));
    }
    
    @Test
    public void emptyName() {
        this.admin.createClass("", 2017, "Instructor", 15);
        assertFalse(this.admin.classExists("", 2017));
    }
   
   
    @Test
    public void duplicate() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.admin.createClass("Test", 2017, "DifferentInstructor", 15);
        assertFalse(this.admin.classExists("Test", 2017));
    }
   
    @Test
    public void notThreeOrMoreClassesPerYear() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.admin.createClass("Test2", 2017, "Instructor", 15);
        this.admin.createClass("Test3", 2017, "Instructor", 15);
        assertFalse(this.admin.classExists("Test3", 2017));
    }
    
    @Test
    public void instructorNameEmpty() {
        this.admin.createClass("Test", 2017, "", 15);
        assertFalse(this.admin.classExists("Test", 2017));
    }

   
    @Test
    public void validNumberOfClasses() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.admin.createClass("Test2", 2017, "Instructor", 15);
        this.admin.createClass("Test3", 2018, "Instructor", 15);
        assertTrue(this.admin.classExists("Test3", 2018));
    }
   
 
}