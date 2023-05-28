import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WomanTests {
    private Woman woman;

    @Test(description = "Check if a woman is not retired")
    public void testIsNotRetired(){
        woman = new Woman("Anna", "Last", 31, "Name", false,"LastNameOriginal");
        Assert.assertFalse(woman.isRetired());
    }

    @Test(description = "Check if a woman is retired")
    public void testIsRetired(){
        woman = new Woman("Bella", "LastName", 60, "LastName", false,"LastNameOriginal");
        Assert.assertTrue(woman.isRetired());
    }

    @Test(description = "Check if partner is changed")
    public void testRegisterPartnershipChanges(){
        woman = new Woman("Bella", "LastName", 60, null, false,"LastNameOriginal");
        woman.registerPartnership();
        Assert.assertEquals(woman.getLastName(), woman.getPartner());
    }

    @Test(description = "Check if a partner is changed, isDivorced is changed and LastName is changed")
    public void testDeregisterPartnershipChanges(){
        woman = new Woman("Bella", "LastName", 60, "LastName", false,"LastNameOriginal");
        woman.deregisterPartnership();
        Assert.assertNotEquals(woman.getPartner(),woman.getLastName());
        Assert.assertTrue(woman.getIsDevorced());
        Assert.assertEquals(woman.getLastName(),woman.getLastNameOriginal());
    }

    @Test(description = "Check if a partner is not changed")
    public void testDeregisterPartnershipNotChanges(){
        woman = new Woman("Bella", "LastNameOriginal", 60, null, false,"LastNameOriginal");
        woman.deregisterPartnership();
        Assert.assertEquals(woman.getPartner(),null);
    }

    @Test(description = "Check if getLastNameOriginal() works")
    public void testGetLastNameOriginal(){
        woman = new Woman("Lisa", "Yong", 60, null, false, "Yong");
        String checkGetter = woman.getLastNameOriginal();
        Assert.assertEquals(checkGetter, woman.getLastNameOriginal());
    }

    @Test(description = "Check if a woman has getLastNameOriginal() not NULL")
    public void testGetLastNameOriginalNotNull(){
        woman = new Woman("Lisa", "Yong", 60, null, false, "Yong");
        String checkGetter = null;
        Assert.assertNotEquals(woman.getLastNameOriginal(),checkGetter);
    }

    @Test(description = "Check if a woman has setLastNameOriginal()")
    public void testSetLastNameOriginal(){
        woman = new Woman("Lisa", "Yong", 60, null, false, "Yong");
        String lastName = "";
        woman.setLastNameOriginal(lastName);
        Assert.assertEquals(woman.getLastNameOriginal(), lastName);
    }

    @Test(description = "Check if setLastNameOriginal() is not set to NULL")
    public void testSetLastNameOriginalNotNull(){
        woman = new Woman("Lisa", "Yong", 60, null, false, "Yong");
        String lastName = "";
        woman.setLastNameOriginal(lastName);
        Assert.assertNotEquals(woman.getLastNameOriginal(), null);
    }

}
