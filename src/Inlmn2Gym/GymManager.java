package Inlmn2Gym;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GymManager { //denna klass läser in kundlistan, customersList.
    List<Customer> customersList = new ArrayList<>(); //lista som sparar användarna

    public void loadCustomers(Path p1) {
        try{
            customersList=Customer.read(p1); //laddar in kunder från customerList, genom att anropa Customer.read()
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Customer nameOrPersonalNumber(String search){ //letar efter en kund genom namn eller pers. nr
        for (Customer customer : customersList) {
            if (customer.getName().equalsIgnoreCase(search) ||
            customer.getPersonalNumber().equalsIgnoreCase(search)){
                return customer; //returnerar Customer-objekt, annars null
            }
        }
        return null;
    }

    public MemberStatus verifyCustomer(String s) {
        Customer customer = nameOrPersonalNumber(s); //söker efter namn eller personnummer för att hitta kunden

    if (customer != null) {
        if(customer.isMembershipValid()) { //om en kund hittas, och dess medlemskap är giltigt returnerar den första enumet
            return MemberStatus.EXISTING_MEMBER;
        } else {
            return MemberStatus.EXPIRED_MEMBER;
        }

    }
    System.out.println("Customer not found: " + s);
    return MemberStatus.UNKNOWN_MEMBER;
    }
}
