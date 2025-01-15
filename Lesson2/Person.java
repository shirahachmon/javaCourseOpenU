package Lesson2;
// second lesson

public class Person {
    private String _name; 
    private int _id; 
    private Date _birthDate;

    public Person(String name, int id, Date d){
        this._name= name;
        this._id= id;
        this._birthDate= new Date(d); // avoid aliasing
    }

    public Date getBirthDate(){
        return new Date(_birthDate);
    }
    
    public String toString(){
        /** When typing this._birthDate it will return the toString() function from the Date object that we had created. */
        return "Name="+ this._name+" id="+ this._id+ " Birthday=" + this._birthDate;
    }

    public boolean equals(Person other){
        return this.toString().equals(other.toString());
    }
}
