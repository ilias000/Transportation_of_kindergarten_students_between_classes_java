package askisiJava.notRoom;

import askisiJava.room.Yard;
import askisiJava.room.Staircase;
import askisiJava.human.student.Student;
import askisiJava.human.Teacher;

public class School implements notRoom
{

    private Floor[] floor = new Floor[3]; 
    private Yard yard = new Yard();
    private Staircase staircase = new Staircase();

    public School(int Cclass) // constructor
    {
        System.out.println("A New School has been created!");
        for(int i = 0 ; i < 3 ; i++)
        {
            this.floor[i] = new Floor(i + 1, Cclass); 
        }
    }


    public void enter(Student student)
    {
        System.out.println(student.getName() + " enters school!");
        yard.enter(student);
        staircase.enter(yard.exit());
        floor[student.getFloorNumber() - 1].enter(staircase.exit());
    }


    public void place(Teacher teacher)
    {
        floor[teacher.getFloorNumber() - 1].place(teacher);
    }


    public void operate(int N)
    {
        for(int i = 0 ; i < 3 ; i++)
        {
            floor[i].operate(N);
        }
    }


    public void print()
    {
        System.out.println("School life consists of: ");
        for(int i = 0 ; i < 3 ; i++)
        {
            System.out.print("\t");
            floor[i].print();
        }
    }


    public void empty()
    {
        for(int i = 0 ; i < 3 ; i++) // for every floor exiting the students
        {
            System.out.println("Floor " + i + " :");
            Student studentThatExited = null;
            do
            {
                studentThatExited = floor[i].exit();
                if(studentThatExited == null) // this floor has not students
                    break;
                staircase.enter(studentThatExited);
                yard.enter(staircase.exit());
                yard.exit();
                System.out.println();
            }while(true); // while the last time we tried to exit a student a student exited
        }

        for(int i = 0 ; i < 3 ; i++) // for every floor exiting the teachers
        {   
                floor[i].teachers_out();     
        }
    }   
}
