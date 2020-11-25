package practice05;

public class Teacher extends Person{
    private Integer klass;
    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public int getKlass(){
        return this.klass;
    }

    @Override
    public String introduce() {
        return String.format("%s I am a Teacher. I teach %s.",super.introduce(),(klass==null?"No Class":"Class "+this.klass));
    }
}
