package pl.dawidpalka;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    public List<Employee> getEmployeesList() throws IOException {
        File file = new File("Employees.json");
        if(!file.exists()){
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("[]");
            fileWriter.flush();
            fileWriter.close();
        }
        String data = "";
        data = new String(Files.readAllBytes(Paths.get("Employees.json")));

        Gson g = new Gson();
        Type listType = new TypeToken<ArrayList<Employee>>(){}.getType();

        return g.fromJson(data, listType);
    }

    public void setEmployeesList(List<Employee> employees) {
        File file = new File("Employees.json");
        Gson g = new Gson();

        String sEmployes = g.toJson(employees);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(sEmployes);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

