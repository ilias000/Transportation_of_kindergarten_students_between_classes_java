package askisiJava.human;

abstract public class Human 
{
    String name;
    int floorNumber, classroomNumber, tiredness, L;
    boolean inside; // if inside == TRUE is inside the classroom 

    public Human(String name, int floorNumber, int classroomNumber, int L) // constructor
    {
        this.name = name;
        this.floorNumber = floorNumber;
        this.classroomNumber = classroomNumber;
        this.tiredness = 0;
        this.L = L;
        this.inside = false;
    }


    public String getName()
    {return name;}

    public int getClassroomNumber()
    {return classroomNumber;}

    public int getFloorNumber()
    {return floorNumber;}

    public int getTiredness()
    {return tiredness;}

    public Boolean getInside()
    {return inside;}

    public void setIsInside()
    {inside = true;}

    public void setIsNotInside()
    {inside = false;}

    public void increaseTiredness() // increases tiredness by L
    {tiredness = tiredness + L;}

    public void print()
    {
        System.out.println("Name = " + name + " Tiredness = " + tiredness + "\n");
    }
}
