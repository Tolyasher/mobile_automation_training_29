import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetLocalNumber()
    {
        System.out.println("Test testGetLocalNumber");
        Assert.assertTrue("Local number != 14", getLocalNumber() == 14);

    }
}
