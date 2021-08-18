
package Composite;

import java.util.ArrayList;
import java.util.List;

public class composite {
    
    public static void main(String args[]){
        
        
        /*                           AhmetTez
                                   /    |       \ 
                           AyseTez  FatmaTezcan NuranTozlu
                          /   |   \________
               HasanYılmaz  FatmaYıldıran  \ ->BurcuYıldız
                                               /        \
                                         ElvanKonak   EbrarKoçak
        */
        
        //output->AhmetTez-AyseTez-HasanYılmaz-FatmaYıldıran-BurcuYıldız-ElvanKonak-EbrarKoçak-FatmaTezcan-NuranTozlu
        
        Manager ahmetTez = new Manager(1, "Ahmet", "Tez");
        Manager ayseTez = new Manager(2, "Ayse", "Tez");
        ahmetTez.addSubordinates(ayseTez);
        ahmetTez.addSubordinates(new Employee(8, "Fatma", "Tezcan"));
        ahmetTez.addSubordinates(new Employee(9, "Nuran", "Tozlu"));
        ayseTez.addSubordinates(new Employee(3, "Hasan", "Yılmaz"));
        ayseTez.addSubordinates(new Employee(4, "Fatma", "Yıldıran"));
        Manager burcuYıldız = new Manager(5, "Burcu", "Yıldız");
        ayseTez.addSubordinates(burcuYıldız);
        burcuYıldız.addSubordinates(new Employee(6, "Elvan", "Konak"));
        burcuYıldız.addSubordinates(new Employee(7, "Ebrar", "Koçak"));
        
        ahmetTez.sendMessage("Learn Design Patterns");
        
    }
    
}

abstract class Person {
    public final String name;
    public final String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    
    abstract void sendMessage(String message);
}

class Employee extends Person{
    public final int employeeID;

    public Employee(int employeeID, String name, String surname) {
        super(name, surname);
        this.employeeID = employeeID;
    }
    
    @Override
    void sendMessage(String message) {
        System.out.println("I am " + name + " " + surname + ", I will do the job " + message);
    }
    
}

class Manager extends Employee{
    
    private final List<Employee> subordinates = new ArrayList<Employee>();

    public Manager(int employeeID, String name, String surname) {
        super(employeeID, name, surname);
    }
    
    Employee addSubordinates(Employee subordinate){
        subordinates.add(subordinate);
        return subordinate;
    }
    
    void removeSubordinate(int employeeId){
        for(Employee employee: subordinates){
            if(employeeId == employee.employeeID){
                subordinates.remove(employee);
            }
        }
    }
    
    Employee getEmployee(int employeeId){
        for(Employee employee: subordinates){
            if(employeeId == employee.employeeID){
                return employee;
            }
        }
        return null;
    }
    
    @Override
    void sendMessage(String message) {
        System.out.println("I am " + name + " " + surname + ", I will order the job " + message + " to my subordinates.");
        
        for(Employee employee: subordinates){
            employee.sendMessage(message);
        }
    }
    
}