package implementation;

import java.util.List;

import interfaces.AdminBeanLocal;
import interfaces.AdminBeanRemote;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import entities.Admin;
import entities.Comment;
import entities.User;
import entities.State;

/**
 * Session Bean implementation class AdminBean
 */
@Stateless
@LocalBean
public class AdminBean implements AdminBeanRemote, AdminBeanLocal {

    /**
     * Default constructor. 
     */
	@PersistenceUnit(name="pictureNetwork")
	private EntityManagerFactory emf;
	private EntityManager em;
    public AdminBean() {
        // TODO Auto-generated constructor stub
    }
    private void begin()
    {
    	if(emf != null)
		{
			em = emf.createEntityManager();
		}
    }
    //tested
	@Override
	public boolean addAdmin(Admin Admin) {
		// TODO Auto-generated method stub
		begin();
		if(em == null)
		{
			System.err.println("\n\n\nEM == NULL\n\n\n");
		}
		if(em != null)
		{
			
			em.persist(Admin);			
			
			
			return true;
		}
		
		
		return false;
	}

	@Override
	public Admin authenticateAdmin(String first, String last, String Password) {
		// TODO Auto-generated method stub
		Admin admin = null;
		
		String query = String.format("select  u from User u where u.firstName = '%s' and  u.lastName = '%s' and u.password = '%s'", first, last, Password);
		List<Admin> admins = em.createQuery(query).getResultList();
		if(admins.size() >= 1)
		{
			admin = admins.get(0);
		}
		
		return admin;
	}
	//to test
	@Override
	public boolean updateAdmin(Admin Admin) {
		// TODO Auto-generated method stub
		if(emf != null)
		{
			em = emf.createEntityManager();
		}
		if(em != null)
		{
			em.merge(Admin);
			return true;
		}
		
		return false;
	}
	//to test
	@Override
	public boolean removeAdmin(Admin Admin) {
		// TODO Auto-generated method stub
		if(emf != null)
		{
			em = emf.createEntityManager();
		}
		if(em != null)
		{
			em.remove(em.contains(Admin) ? Admin : em.merge(Admin));
			return true;
		}
		
		
		return false;
	}

	@Override
	public boolean removeAdmin(int id) {
		// TODO Auto-generated method stub
		if(emf != null)
		{
			em = emf.createEntityManager();
		}
		if(em != null)
		{
			Admin a = findAdmin(id);
			if(a != null)
			{
				em.remove(a);
				return true;
			}
			
		}
		
		return false;
	}

	@Override
	public Admin findAdmin( int id) {
	
		begin();
		
			return em.find(Admin.class, id);
		
		
	}

	@Override
	public List<Admin> findAllAdmins() {
		// TODO Auto-generated method stub
		if(emf != null)
		{
			em = emf.createEntityManager();
		}
		List<Admin> admins = null;
		if(em != null)
		{
			String query = String.format("select  u from User u where u.state = '%s'", State.ADMIN.toString());
			admins =  (List<Admin>) em.createQuery(query).getResultList();
			
		}
		
		return admins;
	}
	@Override
	public Admin authenticate(String lastName, String password) {
		Admin found = null;
		String jpql = "select u from Admin u where u.lastName=:lastName and u.password=:password";
		Query query = em.createQuery(jpql);
		query.setParameter("lastName", lastName);
		query.setParameter("password", password);
		try{
			found = (Admin) query.getSingleResult();
		}catch(Exception ex){
		}
		return found;
	}
	@Override
	public List<Admin> findAllAdmis() {
		return em.createQuery("select u from Admin u").getResultList();
	}

}
