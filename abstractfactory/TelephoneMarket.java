
package abstractfactory;

public class TelephoneMarket {
    
    public static void main(String[] args){
        Note10Factory note10Factory = new Note10Factory();
        Telephone note10 = note10Factory.getTelephone("Note10", "3000mah", 5, 8);

        S10Factory s10Factory = new S10Factory();
        Telephone S10 = s10Factory.getTelephone("S10", "3000mah", 4, 7);
        
        System.out.println("About Note10");
        System.out.println(note10);
        
        System.out.println("About S10");
        System.out.println(S10);
    }
    
}
