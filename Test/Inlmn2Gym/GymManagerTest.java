package Inlmn2Gym;

import org.junit.jupiter.api.Test;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GymManagerTest {
    Path testFilePath = Paths.get("Test/Inlmn2Gym/data.txt");
    GymManager gymManager = new GymManager();



    @Test
    void testExistingMemberVerification(){

        gymManager.loadCustomers(testFilePath);
        MemberStatus status = gymManager.verifyCustomer("7703021234");
        assertEquals(MemberStatus.EXISTING_MEMBER, status);


    }

    @Test
    void testExpiredMemberVerification() {

        gymManager.loadCustomers(testFilePath);
        MemberStatus status = gymManager.verifyCustomer("Per Persson");
        assertEquals(MemberStatus.EXPIRED_MEMBER, status);

    }


    @Test
    void testUnknownMemberVerification() {

    gymManager.loadCustomers(testFilePath);
    MemberStatus status = gymManager.verifyCustomer("9999999999");
    assertEquals(MemberStatus.UNKNOWN_MEMBER, status);

    }





}
