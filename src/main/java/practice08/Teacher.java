package practice08;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return this.klass;
    }

    public String introduceWith(Student student) {
        boolean isSameClass = student.getKlass().getNumber() == this.getKlass().getNumber();
        return String.format("%s I am a Teacher. I %s %s.", super.introduce(), (isSameClass ? "teach" : "don't teach"), student.getName());
    }

    @Override
    public String introduce() {
        return String.format("%s I am a Teacher. I teach %s.", super.introduce(), (klass == null ? "No Class" : this.klass.getDisplayName()));
    }
}
