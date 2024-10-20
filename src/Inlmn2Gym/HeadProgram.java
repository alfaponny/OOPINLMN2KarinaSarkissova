package Inlmn2Gym;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class HeadProgram { //interagerar med GymManager och PersonalTrainer-klasserna
    public static void main(String[] args) throws Exception {
        GymManager gM = new GymManager(); //laddar kunddata från en fil till customersList
        PersonalTrainer pT = new PersonalTrainer();
        Scanner sC = new Scanner(System.in); //skapar tre instanser.

        Path customerFile = Paths.get("src/Inlmn2Gym/fullData.txt");
        gM.loadCustomers(customerFile); //laddar upp kunddata från ovanstående fil

        while (true) { //loopen bjuder in användaren till att söka efter en kund genom namn eller personnummer
            System.out.print("Enter name or personal number to search, or quit to exit the program : ");
            String input = sC.nextLine();

            if ("quit".equalsIgnoreCase(input)) { //loopen fortsätter tills användaren skriver quit.
                System.out.println("Goodbye!");
                break;
            }

            MemberStatus status = gM.verifyCustomer(input);
            switch (status) {
                case EXISTING_MEMBER:
                    System.out.println(status.memberStatus);
                    Customer customer = gM.nameOrPersonalNumber(input);
                    pT.visit(customer.getName(), customer.getPersonalNumber()); //om de är nuvarande medlem registreras deras gymanvänding genom pT.visit()-metoden
                    break;
                case EXPIRED_MEMBER:
                    System.out.println(status.memberStatus);
                    break;
                case UNKNOWN_MEMBER:
                    System.out.println(status.memberStatus);
                    break;
            }
        }


        sC.close();

    }


}

