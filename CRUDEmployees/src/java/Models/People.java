package Models;

/**
 *
 * @author Emilio
 */
public class People
{
    private String id;
    private String name;
    private String email;
    private String Phone;

    public People()
    {
    }

    public People(String id, String name, String email, String Phone)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.Phone = Phone;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return Phone;
    }

    public void setPhone(String Phone)
    {
        this.Phone = Phone;
    }
    
    
    
}
