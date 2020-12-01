package practice10;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> students;
    private List<JoinObserver> joinObservers;
    private List<AssignLeaderObserver> assignLeaderObservers;

    public Klass(int number) {
        this.number = number;
        this.students = new ArrayList<>();
        this.joinObservers = new ArrayList<>();
        this.assignLeaderObservers = new ArrayList<>();
    }

    public int getNumber() {
        return this.number;
    }

    public Student getLeader() {
        return leader;
    }

    public void assignLeader(Student leader) {
        if (students.contains(leader)) {
            this.leader = leader;
            assignLeaderObservers.forEach(observer -> observer.receiveNewLeader(leader, this));
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    public void registerJoinObserver(JoinObserver observer) {
        this.joinObservers.add(observer);
    }

    public void registerAssignLeaderObserver(AssignLeaderObserver observer) {
        this.assignLeaderObservers.add(observer);
    }

    public void appendMember(Student student) {
        this.students.add(student);
        if (!student.getKlass().equals(this)) {
            student.setKlass(this);
        }
        joinObservers.forEach(observer -> observer.receiveNewJoiner(student, this));
    }

    public boolean isIn(Student student) {
        return this.equals(student.getKlass());
    }

    public String getDisplayName() {
        return String.format("Class %s", this.number);
    }
}
