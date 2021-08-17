
package abstractfactory;

//TelephoneFactories were seperated by telephone models. 
//Different models are produced in different factories, the same models are produced in the same factories.
//In Factory pattern, we create all telephones in TelephoneFactory (1 factory) and we decide telephone models with if-else in TelephoneFactory.
//One branch can have multiple telephone models, so we need lots of if-else. In order to do that, we seperate TelephoneFactories with respect to telephone models.
//Than we can create telephones with calling seperate factories, without if-else's.
public interface TelephoneFactory {

    Telephone getTelephone(String model, String battery, int width, int height);
   
}
