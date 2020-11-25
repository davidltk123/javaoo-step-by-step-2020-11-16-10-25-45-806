package practice08;

import java.util.ArrayList;
import java.util.List;

public class Klass {

    private int number;
    private Student leader;
    private List<Student> students;

    public Klass(int number){
        this.number=number;
        this.students = new ArrayList<Student>();
    }

    public int getNumber(){
        return this.number;
    }

    public Student getLeader(){
        return leader;
    }

    public void assignLeader(Student leader){
        if(students.contains(leader)){
            this.leader = leader;
        }
        else{
            System.out.print("It is not one of us.\n");
        }
    }

    public void appendMember(Student student){
        if(!this.students.contains(student)){
            this.students.add(student);
        }
    }

    public String getDisplayName(){
        return String.format("Class %s",this.number);
    }
}
