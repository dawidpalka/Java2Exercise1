package pl.dawidpalka;

import java.io.*;
import java.util.*;

public class hello {
    public static void main(String[] args) throws IOException {

        System.out.println("Welcome, you can use `add` command to add a new employee or `exit` to exit");

        String command = "";

        List<Employee> employees = new EmployeeManager().getEmployeesList();

        int id = 0;

        for (Employee e : employees) {
            id = (e.getId() > id ) ? e.getId()+1 : id;
        }

        Scanner sc = new Scanner(System.in);

        while(!command.equals("exit")){
            command = sc.nextLine();
            if(command.equals("add")) {
                Employee employee = new Employee();
                employee.setId(id++);
                System.out.print("Name: ");
                employee.setName(sc.nextLine());
                System.out.print("Surname: ");
                employee.setSurname(sc.nextLine());
                employee.generateEmail(employees);
                employees.add(employee);
                System.out.println("Employee added. His mail is: " + employee.getEmail());
            }else if(!command.equals("add") && !command.equals("exit")){
                System.out.println("Available commands: add, exit");
            }
        }

        new EmployeeManager().setEmployeesList(employees);


    }
}
