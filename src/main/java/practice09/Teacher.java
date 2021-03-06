package practice09;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private List<Klass> classes = new ArrayList<Klass>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
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
}
