import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;


public class TestNGTests {
    static final Logger logger = LogManager.getLogger(TestNGTests.class.getName());
    private Person sara = new Person("Sara", 4);
    private Person viktor = new Person("Viktor", 40);
    private Person eva = new Person("Eva", 42);

    @BeforeMethod
    void printMessage() {
        logger.info("I'm test! TestNG execute me!");
    }

    @AfterClass
    static void printLastMessage() {
        logger.info("See! These are my tests, cool, aren't they?");
    }



    @Test(priority = 1)
    public void toStringShouldReturnPeopleNamesSeparatedByComma() {
        List<Person> collection = asList(sara, viktor, eva);
        Assert.assertEquals("Names: Sara, Viktor, Eva.", Joining.namesToString(collection));
    }

    @Test(priority = 2)
    public void getOldestPersonShouldReturnOldestPerson() {
        List<Person> collection = asList(sara, eva, viktor);
        Assert.assertEquals(eva, OldestPerson.getOldestPerson(collection));
    }

    @Test(priority = 3)
    public void getKidNameShouldReturnNamesOfYoungerThan18() {
        Person anna = new Person("Anna", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);
        Assert.assertEquals(Kids.getKidNames(collection), asList("Sara", "Anna"));
        Assert.assertNotEquals(Kids.getKidNames(collection), asList("Viktor", "Eva"));
    }
}
