//  
//// --== CS400 File Header Information ==--
//// Name: Timothy Voelker
//// Email: tvoelker@wisc.edu
//// Team: ED
//// Role: Test Engineer
//// TA: Keren Chen
//// Lecturer: Florian Heimerl
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardOpenOption;
//import java.util.NoSuchElementException;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class TestBackEnd implements ITestBackEnd {
//    private static final String DATA_PATH = "./data/data.txt";
//
//    private static BackEnd backEnd;
//
//    @BeforeAll
//    public static void setup() {
//        backEnd = new BackEnd();
//    }
//
//    @Override
//    @Test
//    @Order(1)
//    public void testCanGetEntry() {
//        // Calls BackEnd.getEntry with entry known to be in the address book
//        try {
//            backEnd.getEntry(1);
//        } catch (NoSuchElementException e) {
//            // If the entry is not found
//            fail("Entry not found");
//        }
//    }
//
//    @Override
//    @Test
//    @Order(2)
//    public void testAddNewEntry() {
//        // Call BackEnd add method
//        try {
//            backEnd.addNewEntry(-2, "Test", "123 Main Street", "Small Town", "California", "USA", "test@example.com",
//                    "8675309", 1, 1, 2000);
//        } catch (IllegalArgumentException e) {
//            // Duplicate entry (remove test from your data file!)
//            fail("\n\n\nERROR: Duplicate entry (remove row with \"-2\" from the data.txt file)\n\n\n");
//        }
//
//        // Call BackEnd get method
//        try {
//            backEnd.getEntry(-2);
//        } catch (NoSuchElementException e) {
//            // If the entry isn't found
//            fail("Entry not found");
//        }
//    }
//
//    @Override
//    @Test
//    @Order(3)
//    public void testUpdateEntryName() {
//        String newName = "test";
//
//        // Call BackEnd updateEntryName method
//        backEnd.updateEntryName(-2, newName);
//
//        // The entry's name should be newName
//        assertEquals(backEnd.getEntry(-2).getName(), newName);
//    }
//
//    @Override
//    @Test
//    @Order(4)
//    public void testUpdateEntryAddress() {
//        String newAddress = "321 Main Street";
//        String newTown = "Big Town";
//        String newProvince = "New York";
//        String newCountry = "USA";
//
//        // Call BackEnd updateEntryAddress method
//        backEnd.updateEntryAddress(-2, newAddress, newTown, newProvince, newCountry);
//
//        // Call BackEnd get method
//        AddressBookEntry entry = backEnd.getEntry(-2);
//
//        // The entry's address should be updated
//        assertEquals(entry.getAddress().toString(), String.join(" - ", newAddress, newTown, newProvince, newCountry));
//    }
//
//    @Override
//    @Test
//    @Order(5)
//    public void testUpdateEntryEmail() {
//        String newEmail = "test1@example.com";
//
//        // Call BackEnd updateEntryEmail method
//        backEnd.updateEntryEmail(-2, newEmail);
//
//        // Call BackEnd get method
//        AddressBookEntry entry = backEnd.getEntry(-2);
//
//        // The entry's email should be updated
//        assertEquals(entry.getEmail(), newEmail);
//    }
//
//    @Override
//    @Test
//    @Order(6)
//    public void testUpdateEntryPhoneNumber() {
//        String newPhoneNumber = "123456789";
//
//        // Call BackEnd updateEntryPhoneNumber method
//        backEnd.updateEntryPhoneNumber(-2, newPhoneNumber);
//
//        // Call BackEnd get method
//        AddressBookEntry entry = backEnd.getEntry(-2);
//
//        // The entry's phone number should be updated
//        assertEquals(entry.getPhoneNumber(), newPhoneNumber);
//    }
//
//    @Override
//    @Test
//    @Order(7)
//    public void testUpdateEntryBirthday() {
//        int newBirthdayDay = 2;
//        int newBirthdayMonth = 2;
//        int newBirthdayYear = 2000;
//
//        // Call BackEnd updateEntryBirthday method
//        backEnd.updateEntryBirthday(-2, newBirthdayDay, newBirthdayMonth, newBirthdayYear);
//
//        // Call BackEnd get method
//        AddressBookEntry entry = backEnd.getEntry(-2);
//
//        // The birthday fields of the entry should be updated
//        assertEquals(entry.getBirthday().getDay(), newBirthdayDay);
//        assertEquals(entry.getBirthday().getMonth(), newBirthdayMonth);
//        assertEquals(entry.getBirthday().getYear(), newBirthdayYear);
//    }
//
//    @AfterAll
//    /**
//     * Removes test entry from data file
//     */
//    public static void cleanUp() {
//        try {
//            // Read data and filter out the test entry
//            Stream<String> data = Files.lines(Path.of(DATA_PATH)).filter(line -> !line.split(",")[0].equals("-2"));
//
//            // Write data to file
//            Files.write(Path.of(DATA_PATH), data.collect(Collectors.joining("\n")).getBytes(), StandardOpenOption.WRITE,
//                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
//        } catch (IOException e) {
//            System.out.println("ERROR: Unable to read/write to file");
//        }
//    }
//}