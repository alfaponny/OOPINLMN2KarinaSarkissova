package Inlmn2Gym;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonalTrainerTest {

    @Test
    public void testVisit() {

        Path recordVisits = Paths.get("Test/Inlmn2Gym/recordVisitsTest.txt");
       PersonalTrainer pt = new PersonalTrainer(recordVisits); //passerar till konstruktorn


        try {
            Files.createDirectories(recordVisits.getParent());
            Files.deleteIfExists(recordVisits);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String name = "Anna Andersson";
        String personalNumber = "7502031234";
        pt.visit(name, personalNumber);


        try (BufferedReader reader = new BufferedReader(new FileReader(recordVisits.toFile()))) {
            String line = reader.readLine();
            assertNotNull(line);
            assertTrue(line.contains("Name: " + name));
            assertTrue(line.contains("Personal Number: " + personalNumber));
           assertTrue(line.contains("Visit:"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.deleteIfExists(recordVisits);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
