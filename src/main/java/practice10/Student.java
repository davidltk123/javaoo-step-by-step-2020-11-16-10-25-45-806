package practice10;

public class Student extends Person{
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass(){
        return this.klass;
    }

    @Override
    public String introduce() {
        boolean isLeader = this.klass.getLeader() != null && this.klass.getLeader().equals(this);
        return String.format("%s I am a Student. I am %s %s.",super.introduce(),(isLeader?"Leader of":"at"),this.klass.getDisplayName());
    }
}
