package practice09;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person{
    //private Klass klass;
    private List<Klass> classes = new ArrayList<Klass>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }

    public List<Klass> getClasses(){
        return this.classes;
    }

    public String introduceWith(Student student){
        String result = super.introduce()+" I am a Teacher. ";
        if(this.classes.contains(student.getKlass())){
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
        if(this.classes.size() == 0){
            result += "No Class.";
        }else{
            List<String> classNumbers  = this.classes.stream().map(item -> String.valueOf(item.getNumber())).collect(Collectors.toList());
            String classesString = classNumbers.stream().reduce("Class ",(classString,item) -> {
                if(classNumbers.indexOf(item)==classNumbers.size()-1){
                    return classString+item+".";
                } else{
                    return classString+item+", ";
                }
            });
            result += classesString;
        }
        return result;
    }

    public boolean isTeaching(Student student){
        return this.classes.contains(student.getKlass());
    }
}
