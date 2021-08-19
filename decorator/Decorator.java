
package decorator;

public class Decorator {

    public static void main(String[] args) {
       
        Food menemen = new Menemen();
        System.out.println(menemen.getRecipe());
        System.out.println("Calories of " + menemen.getName() + " is " + menemen.calorie() + "\n-------");
        
        Food menemenWithBologna = new foodWithBologna(new Menemen(), 0.05);
        System.out.println(menemenWithBologna.getRecipe());
        System.out.println("Calories of " + menemenWithBologna.getName() + " is " + menemenWithBologna.calorie() + "\n-------");
        
        Food menemenWithPaper = new foodWithPaper(new Menemen(), 1);
        System.out.println(menemenWithPaper.getRecipe());
        System.out.println("Calories of " + menemenWithPaper.getName() + " is " + menemenWithPaper.calorie() + "\n-------");
        
        Food menemenWithPaperAndCheese = new foodWithPaper(new foodWithCheese(new Menemen(), 0.05), 1);
        System.out.println(menemenWithPaperAndCheese.getRecipe());
        System.out.println("Calories of " + menemenWithPaperAndCheese.getName() + " is " + menemenWithPaperAndCheese.calorie() + "\n-------");
        
        Food karniyarikWithPaper = new foodWithPaper(new Karniyarik(), 2);
        System.out.println(karniyarikWithPaper.getRecipe());
        System.out.println("Calories of " + karniyarikWithPaper.getName() + " is " + karniyarikWithPaper.calorie() + "\n");
    }
}

abstract class Food {
    abstract String getName();
    abstract String getRecipe();
    abstract double calorie();
}

class Menemen extends Food{

    final double tomatos = 0.250;
    final double onion = 0.05;
    final double egg = 2;
    
    @Override
    String getName() {
        return "Menemen";
    }

    @Override
    String getRecipe() {
        return "Tomato x " + tomatos + " gram\n"
                + "Onion x " + onion + " gram\n"
                + egg + " units Egg";
    }

    @Override
    double calorie() {
        return tomatos * 100 + onion * 200 + egg * 125;
    }
}

abstract class foodDecorator extends Food{
    private Food food;

    public foodDecorator(Food food) {
        this.food = food;
    }

    @Override
    double calorie(){
        return food.calorie();
    }

    @Override
    String getRecipe(){
        return food.getRecipe();
    }

    @Override
    String getName(){
        return food.getName();
    }
}

class foodWithBologna extends foodDecorator {
    final double bologna;

    public foodWithBologna(Food food, double amount) {
        super(food);
        this.bologna = amount;
    }
    
    String getName(){
        return super.getName() + " + bologna";
    }
    
    String getRecipe(){
        return super.getRecipe() 
                + "\nBologna x " + bologna + " gram";
    }
    
    double calorie(){
        return super.calorie() + bologna * 150;
    }
}

class foodWithCheese extends foodDecorator{
    final double cheese;

    public foodWithCheese(Food food, double amount) {
        super(food);
        this.cheese = amount;
    }
    
    String getName(){
        return super.getName() + " + cheese";
    }
    
    String getRecipe(){
        return super.getRecipe() 
                + "\nCheese x " + cheese + " gram";
    }
    
    double calorie(){
        return super.calorie() + cheese * 150;
    }
}

class foodWithPaper extends foodDecorator{
    final double paper;

    public foodWithPaper(Food food, double amount) {
        super(food);
        this.paper = amount;
    }
    
    String getName(){
        return super.getName() + " + paper";
    }
    
    String getRecipe(){
        return super.getRecipe() 
                + "\nPaper x " + paper + " gram";
    }
    
    double calorie(){
        return super.calorie() + paper * 150;
    }
}

class Karniyarik extends Food{

    final double tomatos = 0.250;
    final double onion = 0.05;
    final double meat = 0.2;
    
    @Override
    String getName() {
        return "Karniyarik";
    }

    @Override
    String getRecipe() {
        return "Tomato x " + tomatos + " gram\n"
                + "Onion x " + onion + " gram\n"
                + "Meat x " + meat + " gram";
    }

    @Override
    double calorie() {
        return tomatos * 100 + onion * 200 + meat * 125;
    }
}