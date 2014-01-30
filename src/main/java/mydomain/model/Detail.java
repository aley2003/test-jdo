package mydomain.model;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
@FetchGroup(name="subDetails", members={@Persistent(name="subDetails")})
public class Detail
{
    @PrimaryKey
    Long id;

    @Persistent
    String name;
    @Persistent
    Master master;
    
    @Persistent
    @Element(types=SubDetail.class, dependent="false", mappedBy="detail")
    List<SubDetail> subDetails = new ArrayList<SubDetail>();

    public Detail(long id, String name)
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
    public void addSubDetail(SubDetail subDetail) {
    	subDetails.add(subDetail);
    }
}
