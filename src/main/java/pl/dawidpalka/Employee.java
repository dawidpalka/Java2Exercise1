package pl.dawidpalka;

import java.util.List;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private String email;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void generateEmail(List<Employee> employees) {

        int i = 1;
        String email = this.getSurname().toLowerCase()+"."+this.getName().toLowerCase() +"@mex.com";

        for(Employee e : employees){
            if(e.getEmail().equals(email)){
                email = this.getSurname().toLowerCase()+"."+this.getName().toLowerCase() + Integer.toString(i++) +"@mex.com";
            }
        }

        this.email = email;


    }

}
