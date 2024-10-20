package Inlmn2Gym;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

public class PersonalTrainer { //loggar kundbesöken

    private Path recordVisits; //ett Path-objekt som pekar på var filen med filbesök registrerats

    public PersonalTrainer() {
        this.recordVisits = Paths.get("src/Inlmn2Gym/recordVisits.txt");
    }
    public PersonalTrainer(Path recordVisits) {
        this.recordVisits = recordVisits;
    }

    public void visit(String name, String personalNumber){ //denna metod sparar kundens namn, personnummer och datum till recordVisists-filen, genom PrintWriter.
        LocalDate visitDate = LocalDate.now();

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(recordVisits.toFile(), true)))  {
            printWriter.println("Name: " + name + ", Personal Number: " + personalNumber + ", Visit: " + visitDate);
            System.out.println("Recorded gym visit by " + name + " on " + visitDate);
        } catch (IOException e) {
            System.out.println("Error writing to file " + recordVisits.toFile());
        }
    }

}