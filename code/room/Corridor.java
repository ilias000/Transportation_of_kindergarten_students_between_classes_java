package askisiJava.room;

import askisiJava.human.student.Student;

public class Corridor extends Room
{
    public Corridor() // constructor
    {System.out.println("\n" + "A New Corridor has been created!");}

    
    @Override
    public void enter(Student student)
    {
        System.out.println(student.getName() + " enters corridor!");
        super.enter(student);
    }


    @Override
    public Student exit()
    {
        Student studentToExit = super.exit();
        System.out.println(studentToExit.getName() + " exits corridor!");
        return studentToExit;
    }
}