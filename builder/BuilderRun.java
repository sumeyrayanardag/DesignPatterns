
package builder;

//We have two constructors: with no parameters and with all parameters that Product have.
//If we want to create an object with 3 properties out of 6, we can do it with 3 different ways.
//First and second way are on below. Second way uses Builder Pattern.
//Third way is creating new constructors for each object using different properties and it is not good. 
//For 6 properties, there should be lots of different constuctors.

public class BuilderRun {

    public static void main(String[] args) {
        
        //First way
        Product product1 = new Product();
        product1.setId(Long.MIN_VALUE);
        product1.setName("Telephone");
        product1.setDescription("This product has 3000mah battery.");
        
        
        //Second way
        Product product2 = new Product.ProductBuilder()
                .id(Long.MIN_VALUE)
                .name("Telephone")
                .description("This product has 3000mah battery.")
                .build();
        //Product product2 = new Product.ProductBuilder().build()   
        //is equal to   
        //Product product2 = new Product();
        //like default constructor.
        
        //Product.ProductBuilder() returns ProductBuilder, 
        //Product.ProductBuilder().id(Long.MIN_VALUE) also returns ProductBuilder.
        //We can add as many parameters as we want.
        
        
    }
    
}
