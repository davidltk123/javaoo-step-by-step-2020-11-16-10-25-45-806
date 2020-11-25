package practice07;

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
        String result = super.introduce() + " I am a Student. ";
        if(this.klass.getLeader() != null && this.klass.getLeader().equals(this)){
            result += "I am Leader of ";
        }else{
            result += "I am at ";
        }
        result += this.klass.getDisplayName() + ".";
        return result;
    }
}
