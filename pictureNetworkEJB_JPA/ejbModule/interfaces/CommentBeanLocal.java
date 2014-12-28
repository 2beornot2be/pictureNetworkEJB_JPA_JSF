package interfaces;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.Comment;
import entities.Picture;


@Local
public interface CommentBeanLocal {

	
    public void addComment(Comment comment);
	
	
	public void updateComment(Comment comment);
	
	
	public void removeComment(Comment comment);
	
	
	public void removeComment( int id);

	
	public Comment findComment( int id);
	
//	public List<Comment> findAllComment();
	//List<Comment> findAllComment(Picture p);
	
	
	List<Comment> findAllComment( int pictureId);

}
