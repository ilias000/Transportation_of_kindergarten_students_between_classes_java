package askisiJava.room;

import askisiJava.human.student.Student;

abstract public class Room 
{
    Student student;
    
    public Room() // constructor
    {
        this.student = null;
    }


    public void enter(Student student) // enters student
    {
        this.student = student;
    }


    public Student exit() // exits student
    {
        Student studentToExit = student;
        student = null;
        return studentToExit;
    }
}
