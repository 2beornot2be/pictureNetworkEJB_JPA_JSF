package interfaces;

import java.util.List;

import javax.ejb.Local;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

import entities.Picture;
import entities.User;


@Local
public interface PictureBeanLocal {
 
	
	public void addPicture(Picture picture);
	
	
	public void updatePicture(Picture picture);
	
	
	public void removePicture( int id);
	
	
	public Picture findPicture( int id);
	
	
	
	
	public List<Picture> findDesactivated( int pictureId);
	
	
	public List<Picture> findAllPictures();
	
	
	
    public List<Picture> findBySection( String section);
	
	
    public List<Picture> findByName( String name);
	
	
    public List<Picture> findBySubcategory( String pictureSubCategory);

	
	public List<Picture> findByUser( int pictureOwner);

}
