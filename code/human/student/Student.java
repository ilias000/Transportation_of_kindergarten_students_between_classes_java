package askisiJava.human.student;

import askisiJava.human.Human;

abstract public class Student extends Human
{
    public Student(String name, int floorNumber, int classroomNumber, int L) // constructor
    {
        super(name, floorNumber, classroomNumber, L);
        System.out.println("A New Student has been created!");
        System.out.println("Name = " + name);
        System.out.println("Floor number = " + floorNumber);
        System.out.println("Classroom number = " + classroomNumber + "\n");
    }


    public void attend(int N) 
    {
        for(int j = 0 ; j < N ; j++) // for every hour that school operates
            increaseTiredness();
    }
}
