package mydomain.model;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
public class Function
{
    @PrimaryKey
    Long id;

    String name;

    public Function(long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Long getId()
    {
        return id;
    }
}
