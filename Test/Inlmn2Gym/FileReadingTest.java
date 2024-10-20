package Inlmn2Gym;

import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class FileReadingTest {

    Path p = Paths.get("Test/Inlmn2Gym/data.txt");
    Path p1 = Paths.get("Test/Inlmn2Gym/fullData.txt");

    Path noFile = Paths.get("hjkrk/ugf/yyh");

    @Test
    public void testFileReading() throws Exception {

        List<Customer> l =Customer.read(p);

        assertEquals(3, l.size());
        assertEquals("7502031234", l.get(0).getPersonalNumber());
        assertEquals("Anna Andersson", l.get(0).getName());
        assertEquals(LocalDate.of(2023, 5, 3), l.get(0).getLastPaymentDate());

        assertFalse(l.isEmpty());


    }

    @Test
    public void testFullFileReading() throws Exception {

    List<Customer> l1 = Customer.read(p1);

    assertEquals(14, l1.size());
        assertEquals("7703021234", l1.get(0).getPersonalNumber());
        assertEquals("Alhambra Aromes", l1.get(0).getName());
        assertEquals(LocalDate.of(2024,7,1), l1.get(0).getLastPaymentDate());

        assertFalse(l1.isEmpty());

    }
    @Test
    public void testReadNoSuchFile(){
        Throwable exception = assertThrows(NoSuchFileException.class,
                () -> Customer.read(noFile));
    }


}