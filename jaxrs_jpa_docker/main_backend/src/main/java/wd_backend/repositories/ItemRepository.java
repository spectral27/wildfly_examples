package wd_backend.repositories;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import wd_backend.models.Item;

@Stateless
public class ItemRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Item> selectAllItems() {
		return em.createQuery("select i from Item i", Item.class).getResultList();
	}
	
	public void insertItem(Item item) {
		item.setId(UUID.randomUUID().toString());
		em.persist(item);
	}

}
