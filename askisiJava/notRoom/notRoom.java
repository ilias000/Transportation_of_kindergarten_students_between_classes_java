package askisiJava.notRoom;

import askisiJava.human.student.Student;
import askisiJava.human.Teacher;

// for the Classroom, Floor and School
public interface notRoom {
    // public and abstract
    void enter(Student student);

    void place(Teacher teacher);

    void operate(int N);

    void print();
}
