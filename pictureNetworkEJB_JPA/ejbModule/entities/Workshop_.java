package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-29T15:45:00.866+0100")
@StaticMetamodel(Workshop.class)
public class Workshop_ {
	public static volatile SingularAttribute<Workshop, Integer> id;
	public static volatile SingularAttribute<Workshop, String> topic;
	public static volatile SingularAttribute<Workshop, String> description;
	public static volatile SingularAttribute<Workshop, User> owner;
	public static volatile SingularAttribute<Workshop, Date> workshopDate;
	public static volatile SingularAttribute<Workshop, String> address;
	public static volatile ListAttribute<Workshop, User> participants;
}
