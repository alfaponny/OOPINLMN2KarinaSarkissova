package Inlmn2Gym;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String personalNumber;
    private String name;
    private LocalDate lastPaymentDate;

    public Customer(String personalNumber, String name, LocalDate lastPaymentDate) {
        this.personalNumber = personalNumber;
        this.name = name;
        this.lastPaymentDate = lastPaymentDate;
    }//tar desssa argument att initiera Customer-objektet


    public String getName() {
        return name;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public boolean isMembershipValid() {
        return lastPaymentDate.isAfter(LocalDate.now().minusYears(1));
    }

    public static List<Customer> read(Path p1) throws Exception {

        List<Customer> customers = new ArrayList<>();
        String temp;

        try (BufferedReader buf = Files.newBufferedReader(p1)) { //öppnar en fil genom Bufferedreader
            while ((temp = buf.readLine()) != null) { //läser filen rad för rad

                int commaSeparator = temp.indexOf(","); //splittar strängen
                String personalNumber = temp.substring(0, commaSeparator).trim();
                String name = temp.substring(commaSeparator + 1).trim();

                String lastPaymentDateS = buf.readLine().trim();
                LocalDate lastPaymentDate = LocalDate.parse(lastPaymentDateS);

                customers.add(new Customer(personalNumber, name, lastPaymentDate)); //skapar ett nytt objekt Customer

            }

            return customers; //returnerar det nya objektet Customer
        }
    }

}



