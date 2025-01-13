package model;

public class Teacher extends Person {

    
    public int classInCharge;
    public String degree;
    public String subject;

    public Teacher(int id, String name,String image, String dOb, 
            String address, String gender, String username, 
            String password,int classInCharge,String degree,String position,String subject) {
        this.id = id;
        this.name = name;
        this.dOb = dOb;
        this.address = address;
        this.gender = gender;
        this.subject = subject;
        this.degree = degree;
        this.classInCharge = classInCharge;

        this.username = username;
        this.password = password;
        
        this.position = position;
        this.image = image;
    }

    

    public String toString() {
        return this.id + "\n" + this.name +"\n"+this.image+ "\n" + this.dOb + "\n" + this.address
                + "\n" + this.gender +"\n"+this.username+"\n"+this.password+"\n"+this.position+ 
                "\n" + this.classInCharge + "\n" + this.degree+"\n"+this.subject;
    }

}
