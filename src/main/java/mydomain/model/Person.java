package mydomain.model;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
@FetchGroup(name="functions", members={@Persistent(name="functions")})
public class Person
{
    @PrimaryKey
    Long id;

    String name;
    List<Function> functions = new ArrayList<Function>();

    public Person(long id, String name)
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
    public void addFunction(Function function) {
    	functions.add(function);
    }
}
