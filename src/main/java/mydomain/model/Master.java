package mydomain.model;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
@FetchGroup(name="details", members={@Persistent(name="details")})
public class Master
{
    @PrimaryKey
    Long id;
    @Persistent
    String name;
    
    @Persistent()
	@Element(types=Detail.class, dependent="false", mappedBy="master")
    List<Detail> details = new ArrayList<Detail>();

    public Master(long id, String name)
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
    public void addDetail(Detail detail) {
    	details.add(detail);
    }
}
