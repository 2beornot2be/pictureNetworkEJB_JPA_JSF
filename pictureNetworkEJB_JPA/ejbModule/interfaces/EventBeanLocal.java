package interfaces;
//ok
import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.Event;
@Local
public interface EventBeanLocal {


	
	public Event findEvent( int id);

	
	public void removeEvent( int id);

	
	public void removeEvent(Event e);

	
	
	public void CreateEvent(Event e);

	
	public void UpdateEvente(Event e);

	
	
	public List<Event> findAllEvents();

	
	
	public List<Event> findByUser(@PathParam("owner")int owner);
}
