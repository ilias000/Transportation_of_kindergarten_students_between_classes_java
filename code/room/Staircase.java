package askisiJava.room;

import askisiJava.human.student.Student;

public class Staircase extends Room
{
    public Staircase() // constructor
    {System.out.println("A New Stairecase has been created!" + "\n");}

    
    @Override
    public void enter(Student student)
    {
        System.out.println(student.getName() + " enters stairs!");
        super.enter(student);
    }

    @Override
    public Student exit()
    {
        Student studentToExit = super.exit();
        System.out.println(studentToExit.getName() + " exits stairs!");
        return studentToExit;
    }
}
