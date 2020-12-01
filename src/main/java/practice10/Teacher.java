package practice10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person implements JoinObserver, AssignLeaderObserver {
    private List<Klass> classes = new ArrayList<Klass>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        if (!this.classes.isEmpty()) {
            this.classes.forEach(klass -> {
                klass.registerJoinObserver(this);
                klass.registerAssignLeaderObserver(this);
            });
        }
    }

    public List<Klass> getClasses() {
        return this.classes;
    }

    public String introduceWith(Student student) {
        return String.format("%s I am a Teacher. I %s %s.", super.introduce(), (isTeaching(student) ? "teach" : "don't teach"), student.getName());
    }

    @Override
    public String introduce() {
        String classesString = this.classes.stream().map(_class -> String.valueOf(_class.getNumber())).collect(Collectors.joining(", "));
        return String.format("%s I am a Teacher. I teach %s.", super.introduce(), (this.classes.isEmpty() ? "No Class" : "Class " + classesString));
    }

    public boolean isTeaching(Student student) {
        return this.classes.stream().filter(_class -> _class.isIn(student)).count() > 0;
    }

    @Override
    public void receiveNewLeader(Student student, Klass klass) {
        System.out.printf("I am %s. I know %s become Leader of %s.\n", this.getName(), student.getName(), student.getKlass().getDisplayName());
    }

    @Override
    public void receiveNewJoiner(Student student, Klass klass) {
        System.out.printf("I am %s. I know %s has joined %s.\n", this.getName(), student.getName(), student.getKlass().getDisplayName());
    }
}
