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
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.Assert.*;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.Test;
//
//public class TestDataAccess implements ITestDataAccess {
//    private static final String DATA_PATH = "./data/data.txt";
//
//    @Override
//    @Test
//    public void testCanLoadData() {
//        try {
//            DataAccess.loadData();
//        } catch (IOException e) {
//            // If an IO exception is thrown, then the method isn't currently working
//            fail("Failed to load data");
//        }
//    }
//
//    @Override
//    @Test
//    public void testCanSaveData() {
//        try {
//            RedBlackTree<AddressBookEntry> data = DataAccess.loadData();
//            DataAccess.saveData(data);
//        } catch (IOException e) {
//            // If an IO exception is thrown, then the method isn't currently working
//            fail("Failed to save data");
//        }
//    }
//
//    @Override
//    @Test
//    public void testChangesData() {
//        try {
//            AddressBookEntry entry = new AddressBookEntry(-1, "Test",
//                    new Address("123 Main Street", "Small Town", "California", "USA"), "test@example.com", "8675309",
//                    new Date(1, 1, 2000));
//
//            // Load data
//            RedBlackTree<AddressBookEntry> data = DataAccess.loadData();
//
//            // Change data
//            try {
//                data.insert(entry);
//            } catch (IllegalArgumentException e) {
//                fail("\n\n\nERROR: Duplicate entry (remove row with \"-1\" from the data.txt file)\n\n\n");
//            }
//
//            // Save data
//            DataAccess.saveData(data);
//
//            // Load data again
//            RedBlackTree<AddressBookEntry> data2 = DataAccess.loadData();
//
//            // Binary search through tree for AddressBookEntry object
//            RedBlackTree.Node<AddressBookEntry> tmp = data2.root;
//
//            while (tmp != null) {
//                if (tmp.data.compareTo(entry) == 0) {
//                    // The change was saved
//                    break;
//                }
//
//                // Entry comes before data
//                if (tmp.data.compareTo(entry) > 0) {
//                    // Search the left sub tree
//                    tmp = tmp.leftChild;
//                } else {
//                    // Search the right sub tree
//                    tmp = tmp.rightChild;
//                }
//            }
//
//        } catch (IOException e) {
//            // If an IO exception is thrown, then one of the methods isn't working
//            fail("Failed to load/save data");
//        }
//    }
//
//    @AfterAll
//    /**
//     * Removes test entry from data file
//     */
//    public static void cleanUp() {
//        try {
//            // Read data and filter out the test entry
//            Stream<String> data = Files.lines(Path.of(DATA_PATH)).filter(line -> !line.split(",")[0].equals("-1"));
//
//            // Write data to file
//            Files.write(Path.of(DATA_PATH), data.collect(Collectors.joining("\n")).getBytes(), StandardOpenOption.WRITE,
//                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
//        } catch (IOException e) {
//            System.out.println("ERROR: Unable to read/write to file");
//        }
//    }
//}
