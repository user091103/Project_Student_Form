package model;



import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Student extends Person {

    public int grade;
    
    
    

    public TreeMap<String, Double> store_Score = new TreeMap<>();

    public Student(int id, String name,String image, String dOb, String address, String gender, int grade, String username, String password,String position) {
        this.id = id;
        this.name = name;
        this.dOb = dOb;
        this.address = address;
        this.gender = gender;
        this.grade = grade;
        this.username = username;
        this.password = password;
        this.store_Score.put("Maths", 0.0);
        this.store_Score.put("Chemistry", 0.0);
        this.store_Score.put("Physics", 0.0);
        this.position = position;
        this.image = image;
        
        
    }

    public String calculateScore() {
        double res = 0;
        for (Map.Entry<String, Double> entry : this.store_Score.entrySet()) {
            res += entry.getValue() / this.store_Score.size();
        }
        return String.format("%.2f", res);
    }

    public String toString() {
        return this.id + "\n" + this.name +"\n"+this.image+ "\n" + this.dOb + "\n" + this.address + "\n"
                + this.gender  + "\n" + this.username + "\n"
                + this.password +"\n"+this.position+ "\n" + this.grade+"\n" + "Maths" + "\n" + this.store_Score.get("Maths")
                + "\n" + "Chemistry" +"\n"+ this.store_Score.get("Chemistry") + "\n"
                + "Physics" + "\n" + this.store_Score.get("Physics");

    }

}
