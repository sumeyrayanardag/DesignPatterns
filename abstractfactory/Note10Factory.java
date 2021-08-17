
package abstractfactory;

public class Note10Factory implements TelephoneFactory{
    
    public Telephone getTelephone(String model, String battery, int width, int height){
        return new Note10(model, battery, width, height);
    }
    
}
