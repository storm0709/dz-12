import org.example.Man;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManTests {
    private Man man;

    @Test(description = "Check if a man is not retired")
    public void testIsNotRetired(){
        man = new Man("Bob", "Last", 31, "Name", false);
        Assert.assertFalse(man.isRetired());
    }

    @Test(description = "Check if a man is retired")
    public void testIsRetired(){
        man = new Man("John", "LastName", 65, "LastName", false);
        Assert.assertTrue(man.isRetired());
    }

    @Test(description = "Check if partner is changed")
    public void testRegisterPartnershipChanges(){
        man = new Man("John", "LastName", 60, null, false);
        man.registerPartnership();
        Assert.assertEquals(man.getLastName(), man.getPartner());
    }

    @Test(description = "Check if a partner is changed and isDivorced is changed")
    public void testDeregisterPartnershipChanges(){
        man = new Man("John", "LastName", 60, "none", false);
        man.deregisterPartnership();
        Assert.assertNotEquals(man.getLastName(), man.getPartner());
        Assert.assertTrue(man.getIsDevorced());
    }

    @Test(description = "Check if a partner is not changed")
    public void testDeregisterPartnershipNotChanges(){
        man = new Man("John", "LastName", 60, null, false);
        man.deregisterPartnership();
        Assert.assertEquals(man.getPartner(), null);
    }
}

