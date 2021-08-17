
package factory;

public class TelephoneMarket {
    public static void main(String[] args) {
        
        Telephone S10 = Factory.getTelephone("S10", "3000mah", 4, 7);
        Telephone Note10 = Factory.getTelephone("Note10", "3000mah", 5, 8);
        
        System.out.println("About S10");
        System.out.println(S10);
        
        System.out.println("About Note10");
        System.out.println(Note10);
        
    }
}
