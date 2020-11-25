package practice06;

public class Klass {
    private int number;
    public Klass(int number){
        this.number=number;
    }

    public int getNumber(){
        return this.number;
    }

    public String getDisplayName(){
        return "Class "+ this.number;
    }
}
