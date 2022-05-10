package individual.jaxrs_ejb_jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ControlRepositoryBean implements ControlRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Control> selectAllControls() {
		return em.createQuery("select c from Control c", Control.class).getResultList();
	}

	@Override
	public Control selectControl(int id) {
		return em.find(Control.class, id);
	}

	@Override
	public void insertControl(Control control) {
		em.persist(control);		
	}

	@Override
	public Control updateControl(int id, Control control) {
		Control toUpdate = em.find(Control.class, id);
		toUpdate = control;
		toUpdate.setId(id);
		return em.merge(toUpdate);
	}

	@Override
	public void deleteControl(int id) {
		Control toDelete = em.find(Control.class, id);
		em.remove(toDelete);		
	}
	
}
