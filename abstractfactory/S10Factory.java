
package abstractfactory;

public class S10Factory implements TelephoneFactory{
    public Telephone getTelephone(String model, String battery, int width, int height){
        return new S10(model, battery, width, height);
    }
}
