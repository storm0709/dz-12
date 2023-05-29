import org.example.Man;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ManTests {
    private Man man;

    @Test(description = "Check if a man is not retired", dataProvider = "age", dataProviderClass = TestDataProviders.class)
    public void testIsNotRetired(int age){
      man = new Man("Bob", "Last", age, "Name", false);
        Assert.assertFalse(man.isRetired(), "Age "+man.getAge()+" is 65+ years");
    }

    @Test(description = "Check if a man is retired", dataProvider = "age", dataProviderClass = TestDataProviders.class)
    public void testIsRetired(int age){
        man = new Man("John", "LastName", age, "LastName", false);
        Assert.assertTrue(man.isRetired(), "Age "+man.getAge()+" is below 65 years");
    }

    @Test(description = "Check if partner is changed", dataProvider = "lastName", dataProviderClass = TestDataProviders.class)
    public void testRegisterPartnershipChanges(String lastName){
        man = new Man("John", lastName, 60, "LastName", false);
        man.registerPartnership(lastName);
        Assert.assertEquals(man.getLastName(), man.getPartner());
    }

    @Test(description = "Check if a partner is changed and isDivorced is changed when had one before", dataProvider = "partnerDivorced", dataProviderClass = TestDataProviders.class)
    public void testDeregisterPartnershipChanges(String partner, Boolean divorced){
        man = new Man("John", "LastName", 60, partner, divorced);
        man.deregisterPartnership();
        Assert.assertNotEquals(man.getLastName(), man.getPartner());
        Assert.assertTrue(man.getIsDevorced(), "The field 'isDivorced' set to false");
    }

    @Test(description = "Check if a partner is not changed when didn't have one before", dataProvider = "partnerDivorced", dataProviderClass = TestDataProviders.class)
    public void testDeregisterPartnershipNotChanges(String partner, Boolean divorced){
        man = new Man("John", "LastName", 60, partner, divorced);
        man.deregisterPartnership();
        Assert.assertEquals(man.getPartner(),null);
    }
}

