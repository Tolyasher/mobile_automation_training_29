import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetClassString()
    {
        System.out.println("Test testGetClassNumber");
        Assert.assertTrue("'hello' and 'Hello' words are not in the text = '" + getClassString() + "'", checkStrings());
    }
}
