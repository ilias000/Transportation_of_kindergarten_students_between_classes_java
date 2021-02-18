package askisiJava.notRoom;

import askisiJava.human.student.Student;
import askisiJava.human.Teacher;

public class Classroom implements notRoom
{
    
    private int classroomNumber, Cclass;
    private Student[] student;
    private Teacher teacher;

    public Classroom(int classroomNumber, int Cclass) // constructor
    {
        System.out.println("A New Classroom has been created!");
        this.classroomNumber = classroomNumber;
        this.Cclass = Cclass;
        this.teacher = null;

        this.student = new Student[Cclass]; 
        for(int i = 0 ; i < Cclass ; i++)
        {
            student[i] = null;
        }
    }


    public void enter(Student student)
    {
        System.out.println(student.getName() + " enters classroom!");
        for(int i = 0 ; i < Cclass ; i++) // putting in the first free position at the array of the classroom for the students the student that just entered the classroom
        {
            if(this.student[i] == null)
            {
                this.student[i] = student;
                break; 
            }
        }
        student.setIsInside();
    }


    public void place(Teacher teacher)
    {
        this.teacher = teacher;
        teacher.setIsInside();
    }


    public void operate(int N)
    {
        for(int i = 0 ; i < Cclass ; i++) // for all the students of the class
        {
            student[i].attend(N);
        }

        teacher.teach(N);
    }


    public void print()
    {
        System.out.println("People in class " + classroomNumber + " are: ");
        for(int i = 0 ; i < Cclass ; i++)
        {
            System.out.print("\t" + "\t" + "\t");
            student[i].print();
        }
        System.out.print("\t" + "\t" + "\t");
        teacher.print();
    }


    public Student exit()
    {
        Student studentThatExited = null;
        for(int i = 0 ; i < Cclass ; i++)
        {
            if(student[i] != null) // we will exit this student
            {
                studentThatExited = student[i];
                student[i] = null;
                break;
            }
        }

        if(studentThatExited != null)
        {
            System.out.println(studentThatExited.getName() + " exits classroom!");
            studentThatExited.setIsNotInside();
        }
        // else this classroom is empty
        return studentThatExited;
    }


    public void teacher_out()
    {
        teacher.setIsNotInside();
        System.out.println("Name : " + teacher.getName());
        System.out.println("FloorNumber : " + teacher.getFloorNumber());
        System.out.println("ClassroomNumber : " + teacher.getClassroomNumber());
        System.out.println("Inside : " + teacher.getInside());
        System.out.println("Tiredness : " + teacher.getTiredness());
        System.out.println("...teacher is out!" + '\n');
        teacher = null;
    }
}
