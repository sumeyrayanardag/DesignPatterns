
package observer;

import java.util.ArrayList;
import java.util.List;

//If something changes in one place and other places want to be informed about it, we use observer design pattern.
//We have termometer(observable) and mother, father(observer).
//If current temperature is smaller than minTemperature or current temperature is bigger than maxTemperature then temperature gives alarm to observers(mother, father).

public class Test {

    public static void main(String[] args) {
        
        int minTemperature = 22;
        int maxTemperature = 26;
        Termometer termometer = new Termometer(minTemperature, maxTemperature);
        
        Parent mother = new Parent("Mother");
        Parent father = new Parent("Father");
        
        termometer.add(mother);
        termometer.add(father);
        
        for(int i=termometer.getCurrentTemperature(); i<=28; i++){
            termometer.setCurrentTemperature(i);
        }
        
        for(int i=termometer.getCurrentTemperature(); i>=21; i--){
            termometer.setCurrentTemperature(i);
        }
        
    }
    
}

interface Observer {
    void update(Observable observable);
}

abstract class Observable {
    
    List<Observer> observerList;

    public Observable() {
        this.observerList = new ArrayList<>();
    }

    public void add(Observer observer){
        observerList.add(observer);
    }
    
    public void remove(Observer observer){
        observerList.remove(observer);
    }
    
    public void inform(){
        for(Observer observer : observerList){
            observer.update(this);
        }
    }
}

class Termometer extends Observable{

    private int currentTemperature;
    private int minTemperature;
    private int maxTemperature;

    public Termometer(int minTemperature, int maxTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.currentTemperature = 24;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(int currentTemperature) {
        this.currentTemperature = currentTemperature;
        
        System.out.println(currentTemperature);
        controlTemperature();
    }
    
    public void controlTemperature(){
        if(currentTemperature <= minTemperature || currentTemperature >= maxTemperature){
            inform();
        }
    }    
}

class Parent implements Observer{

    String name;

    public Parent(String name) {
        this.name = name;
    }
    
    @Override
    public void update(Observable observable) {
        
        Termometer termometer = (Termometer) observable;
        
        System.out.println(name + " is said: Ooo, the temperature is " + termometer.getCurrentTemperature());
    }
    
}