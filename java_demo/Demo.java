import com.oracle.jrockit.jfr.InvalidValueException;

//CamelCase Class/interface
//cameCase variable/func

class Student{
    private int id;
    private String name;
  
    public void setId(int id_) throws Exception{
        if(id_>0){
            this.id=id_;}
        else{
            throw new Exception("invalid age");}
    }
  
    public int getId(){
        return this.id;
    }
    
    Student(){
        this.id=1;
        this.name="Stud";
    }
    public void show(){
        System.out.println(this.id+":"+this.name);
    }
    Student(int id_,String name_){
        this.id=id_;
        this.name=name_;
    }
}
public class Demo{
    public static void main(String[] args) {
        System.out.println("Hello");    
        Student s1=new Student();
        s1.show();
    }
} 