package implementation;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import entities.BadWorld;
import entities.Workshop;
import interfaces.WorkShopBeanLocal;
import interfaces.WorkShopBeanRemote;

@Stateless
public class WorkShopBean implements WorkShopBeanLocal,WorkShopBeanRemote {
	@PersistenceUnit(unitName = "pictureNetwork")
	private EntityManagerFactory emf;
	private EntityManager em;
	
	private void begin() {
		if (emf != null) {
			em = emf.createEntityManager();
		}
	}
	@Override
	public boolean addWorkShop(Workshop workshop) {
		begin();
		em.merge(workshop);
		return true;
	}

	@Override
	public boolean updateWorkShop(Workshop workshop) {
		em.merge(workshop);
		return true;
	}

	@Override
	public boolean removeWorkShop(Workshop workshop) {
		em.remove(workshop);
		return true;
	}

	@Override
	public boolean removeWorkShop(int id) {
		if (em != null) {
			Workshop a = findWorkShop(id);
			if (a != null) {
				em.remove(a);
				return true;
			}

		}

		return false;

	}

	@Override
	public Workshop findWorkShop(int id) {
		Workshop workshop = null;
		if (em != null) {
			return em.find(Workshop.class, id);

		}
		return workshop;
	}

	

	@Override
	public List<Workshop> findAllWorkShop() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
