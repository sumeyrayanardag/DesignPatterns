
package factory;

public class Factory {

    //You can use this design pattern when we want to create an architectural standard for object generation. 
    //Another benefit is that it allows us to correctly generate an object without domain knowledge.
    
    public static Telephone getTelephone(String model, String battery, int width, int height){
        
        Telephone telephone;
        
        if("S10".equalsIgnoreCase(model)){
            telephone = new S10(model, battery, width, height);
        }
        else if("Note10".equalsIgnoreCase(model)){
            telephone = new Note10(model, battery, width, height);
        }
        else{
            throw new RuntimeException("Model is not found!");
        }
        
        return telephone;
    }
   
}
