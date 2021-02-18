package askisiJava;

import askisiJava.notRoom.School;
import java.util.Random;
import askisiJava.human.student.*;
import askisiJava.human.Teacher;

class Main
{
    public static void main(String[] args)
    {

        System.out.println("                             --- THE PROGRAM STARTED ---                                 ");

        System.out.println("\n" + "-----------------------------------------------------------------------------------------------------------------------------" + "\n");
        System.out.println("                       1. Create the School.");
        System.out.println("\n" + "-----------------------------------------------------------------------------------------------------------------------------" + "\n");

        int Cclass = Integer.parseInt(args[0]), Lj = Integer.parseInt(args[1]), Ls = Integer.parseInt(args[2]), Lt = Integer.parseInt(args[3]), N = Integer.parseInt(args[4]);
        System.out.println("Cclass = " + Cclass);
        System.out.println("Lj = " + Lj);
        System.out.println("Ls = " + Ls);
        System.out.println("Lt = " + Lt);
        System.out.println("N = " + N + "\n");
        School school = new School(Cclass);

        System.out.println("\n" + "-----------------------------------------------------------------------------------------------------------------------------" + "\n");
        System.out.println("                       2. Create the students and the teachers.");
        System.out.println("\n" + "-----------------------------------------------------------------------------------------------------------------------------" + "\n");

        System.out.println("                                ~ Creating Students ~ " + "\n");

        Random random = new Random();
        int totalNumberOfStudents = 18 * Cclass;
        Student[] student = new Student[totalNumberOfStudents];

        for(int i = 1, floorNumber = 1, classroomNumber = 1, studentForThisClass = 0 ; i <= totalNumberOfStudents ; i++)
        {
            int randomIntegerForName = random.nextInt(20); // random number [0,19]
            // random names
            String name[] = {"MARIA", "ELENH", "GEORGIOS", "AIKATERINH", "BASILIKH", "CLAIRE", "KWNSTANTINOS", "IWANNHS", "NIKOLAOS", "GEWRGIA", "SOFIA", "ANASTASIA", "EYAGGELIA", "IWANNA", "XRHSTOS", "PANAGIWTHS", "BASILEIOS", "ATHANASIOS", "MIXAHL", "SPYRIDWN"}; // array to choose a random name 	
            if(classroomNumber <= 3) // is a classroom with Junior students
                student[i-1] = new Junior(name[randomIntegerForName], floorNumber, classroomNumber, Lj); // creating Junior student with random name and inserting him to the array
            else // else is a classroom with Senior students
                student[i-1] = new Senior(name[randomIntegerForName], floorNumber, classroomNumber, Ls); // creating Senior student with random name and inserting him to the array
            studentForThisClass++;
            if(studentForThisClass == Cclass) // this class is full
            {
                classroomNumber++;
                studentForThisClass = 0;
                if(classroomNumber == 7) // all the classrooms of the floor are full
                {
                    floorNumber++;
                    classroomNumber = 1;
                }
            }
        }

        System.out.println("\n" + "-----------------------------------------------------------------------------------------------------------------------------" + "\n");

        System.out.println("                                ~ Creating Teachers ~ " + "\n");


        Teacher[] teacher = new Teacher[18];

        for(int i = 1, floorNumber = 1, classroomNumber = 1 ; i <= 18 ; i++, classroomNumber++)
        {
            int randomIntegerForName = random.nextInt(18); // random number [0,17]
            // random names
            String name[] = {"MARIA", "ELENH", "GEORGIOS", "AIKATERINH", "BASILIKH", "CLAIRE", "KWNSTANTINOS", "IWANNHS", "NIKOLAOS", "GEWRGIA", "SOFIA", "ANASTASIA", "EYAGGELIA", "IWANNA", "XRHSTOS", "PANAGIWTHS", "BASILEIOS", "ATHANASIOS"}; // array to choose a random name 
            // we want every teacher to have a different classroom
            teacher[i-1] = new Teacher(name[randomIntegerForName], floorNumber, classroomNumber, Lt); // creating teachers with random names and inserting them to the array
            if(classroomNumber == 6)
            {
                floorNumber++;
                classroomNumber = 0; 
            }
        }

        System.out.println("\n" + "-----------------------------------------------------------------------------------------------------------------------------" + "\n");
        System.out.println("                       3. Enter the students and place the teachers inside the school randomly."); 	
        System.out.println("\n" + "-----------------------------------------------------------------------------------------------------------------------------" + "\n");

        int randomIndexOfStudent, randomIndexOfTeacher;
        for(int i = 0 ; i < totalNumberOfStudents ; i++) // entering all the students 
        {
            do // random student to enter
            {
                randomIndexOfStudent = random.nextInt(totalNumberOfStudents); // random number between [0 , total number of students)
            }while(student[randomIndexOfStudent] == null); // if the student has already entered find another random one
            school.enter(student[randomIndexOfStudent]);
            student[randomIndexOfStudent] = null;
            System.out.println("\n");
        }

        for(int i = 0 ; i < 18 ; i++) // entering all the teachers 
        {
            do // random teacher to enter
            {
                randomIndexOfTeacher = random.nextInt(18); // random number between [0 , 18)
            }while(teacher[randomIndexOfTeacher] == null); // if the teacher has already entered find another random one
            school.place(teacher[randomIndexOfTeacher]);
            teacher[randomIndexOfTeacher] = null;
        }

        System.out.println("\n" + "-----------------------------------------------------------------------------------------------------------------------------" + "\n");
        System.out.println("                       4. Operate the school for N hours.");
        System.out.println("\n" + "-----------------------------------------------------------------------------------------------------------------------------" + "\n");

        school.operate(N);


        System.out.println("\n" + "-----------------------------------------------------------------------------------------------------------------------------" + "\n");
        System.out.println("                       5. Empty the school.");
        System.out.println("\n" + "-----------------------------------------------------------------------------------------------------------------------------" + "\n");
        school.empty();

        System.out.println("                             --- THE PROGRAM ENDED ---                                 " + "\n");

    }
}
