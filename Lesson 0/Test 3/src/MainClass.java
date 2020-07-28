public class MainClass
{
    private String class_string = "Hello, world";
    public String getClassString()
    {
        return class_string;
    }
    public boolean checkStrings()
    {
        if (getClassString().contains("Hello")  || getClassString().contains("hello")){
            return true;
        } else {return false;
        }
    }
}
