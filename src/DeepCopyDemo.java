class Course1 implements Cloneable
{
    String subject1;
 
    String subject2;
 
    String subject3;
 
    public Course1(String sub1, String sub2, String sub3)
    {
        this.subject1 = sub1;
 
        this.subject2 = sub2;
 
        this.subject3 = sub3;
    }
 
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
 
class Student2 implements Cloneable
{
    int id;
 
    String name;
 
    Course1 course;
 
    public Student2(int id, String name, Course1 course)
    {
        this.id = id;
 
        this.name = name;
 
        this.course = course;
    }
 
    //Overriding clone() method to create a deep copy of an object.
 
    protected Object clone() throws CloneNotSupportedException
    {
        Student2 student = (Student2) super.clone();
 
        student.course = (Course1) course.clone();
 
        return student;
    }
}
 
public class DeepCopyDemo
{
    public static void main(String[] args)
    {
        Course1 science = new Course1("Physics", "Chemistry", "Biology");
 
        Student2 student1 = new Student2(111, "John", science);
 
        Student2 student2 = null;
 
        try
        {
            //Creating a clone of student1 and assigning it to student2
 
            student2 = (Student2) student1.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
 
        //Printing the subject3 of 'student1'
 
        System.out.println(student1.course.subject3);         //Output : Biology
 
        //Changing the subject3 of 'student2'
 
        student2.course.subject3 = "Maths";
 
        //This change will not be reflected in original student 'student1'
 
        System.out.println(student1.course.subject3);       //Output : Biology
    }
}