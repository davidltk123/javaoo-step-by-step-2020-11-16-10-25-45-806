package practice10;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> students;
    private Teacher teacher;

    public Klass(int number){
        this.number = number;
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
            notisfyTeacher(this, leader, true);
        }
        else{
            System.out.print("It is not one of us.\n");
        }
    }

    public void assignTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public void notisfyTeacher(Klass klass, Student student, boolean isLeader){
        if(this.teacher!=null){
            this.teacher.introduceNew(klass,student,isLeader);
        }
    }

    public void appendMember(Student student){
        this.students.add(student);
        this.notisfyTeacher(this,student, false);
    }

    public boolean isIn(Student student){
        return this.equals(student.getKlass());
    }

    public String getDisplayName(){
        return String.format("Class %s",this.number);
    }
}
