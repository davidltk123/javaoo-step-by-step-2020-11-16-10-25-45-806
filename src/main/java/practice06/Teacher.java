package practice06;

public class Teacher extends Person{

    private Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Klass getKlass(){
        return this.klass;
    }

    public String introduceWith(Student student){
        String result = super.introduce()+" I am a Teacher. ";
        if(student.getKlass().getNumber()==this.getKlass().getNumber()){
            result += "I teach ";
        }
        else{
            result += "I don't teach ";
        }
        result += student.getName() +".";

        return result;
    }

    @Override
    public String introduce() {
        String result = super.introduce()+" I am a Teacher. I teach ";
        if(klass == null){
            result += "No Class.";
        }else{
            result += this.klass.getDisplayName()+".";
        }
        return result;
    }
}
