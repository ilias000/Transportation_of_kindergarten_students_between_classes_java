package askisiJava.notRoom;

import askisiJava.room.Corridor;
import askisiJava.human.student.Student;
import askisiJava.human.Teacher;

public class Floor implements notRoom
{
    private int floorNumber;
    private Classroom[] classroom = new Classroom[6];
    private Corridor corridor = new Corridor();


    public Floor(int floorNumber, int Cclass) // constructor
    {
        System.out.println("A New Floor has been created!");
        this.floorNumber = floorNumber;

        for(int i = 0 ; i < 6 ; i++)
        {
            this.classroom[i] = new Classroom(i + 1, Cclass);
        }
    }


    public void enter(Student student)
    {
        System.out.println(student.getName() + " enters floor!");
        corridor.enter(student);
        classroom[student.getClassroomNumber() - 1].enter(corridor.exit());
    }


    public void place(Teacher teacher)
    {
        classroom[teacher.getClassroomNumber() - 1].place(teacher);
    }


    public void operate(int N)
    {
        for(int i = 0 ; i < 6 ; i++)
        {
            classroom[i].operate(N);
        }
    }

    public void print()
    {
        System.out.println(" Floor number " + floorNumber + " contains: ");
        for(int i = 0 ; i < 6 ; i++)
        {
            System.out.print("\t" + "\t" + "\t"); 
            classroom[i].print();
        }
    }


    public Student exit()
    {
        Student studentThatExited = null;
        for(int i = 0 ; i < 6 ; i++) // for every classroom of the floor
        {
            studentThatExited = classroom[i].exit();
            if(studentThatExited != null) // this classroom had a student so we exit this student else we go to the next class
                break;
        }
        if(studentThatExited != null)
        {
            System.out.println(studentThatExited.getName() + " starts exiting!");
            corridor.enter(studentThatExited);
            corridor.exit();
        }
        //else this floor is empty
        return studentThatExited;
    }


    public void teachers_out()
    {
        for(int i = 0 ; i < 6 ; i++)
        {
            classroom[i].teacher_out();
        }
    }
}
