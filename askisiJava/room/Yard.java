package askisiJava.room;

import askisiJava.human.student.Student;

public class Yard extends Room
{
    public Yard() // constructor
    {System.out.println("A New Yard has been created!" + "\n");}

    
    @Override
    public void enter(Student student)
    {
        System.out.println(student.getName() + " enters schoolyard!");
        super.enter(student);
    }


    @Override
    public Student exit()
    {
        Student studentToExit = super.exit();
        System.out.println(studentToExit.getName() + " exits schoolyard!");
        return studentToExit;
    }
}
