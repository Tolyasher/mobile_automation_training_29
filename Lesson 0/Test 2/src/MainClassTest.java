import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetClassNumber()
    {
        System.out.println("Test testGetClassNumber");
        Assert.assertTrue("class_number <= 45", getClassNumber() > 45);

    }
}
