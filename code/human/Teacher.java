package askisiJava.human;

public class Teacher extends Human
{
   public Teacher(String name, int floorNumber, int classroomNumber, int Lt) // constructor
    {
        super(name, floorNumber, classroomNumber, Lt);
        System.out.println("A New Teacher has been created!");
        System.out.println("Name = " + name);
        System.out.println("Floor number = " + floorNumber);
        System.out.println("Classroom number = " + classroomNumber + "\n");
    }

  
    public void teach(int N)
    {
        for(int j = 0 ; j < N ; j++) // for every hour that school operates
            increaseTiredness();
    }

    
    @Override
    public void print()
    {
        System.out.println("The teacher is : ");
        System.out.print("\t" + "\t" + "\t");
        super.print();
    }
}
