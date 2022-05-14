package individual.jaxrs_ejb_jpa_mysql;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RecordRepositoryBean implements RecordRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private Generators generators;
	
	public List<Record> selectAllRecords() {
		return entityManager.createQuery("select r from Record r", Record.class).getResultList();
	}
	
	public Record selectRecord(String id) {
		return entityManager.find(Record.class, id);
	}

	public void insertRecord(Record record) {
		if (record == null) {
			record = new Record();
			record.setContent(generators.generateContent());
		}
		
		record.setId(UUID.randomUUID().toString());
		record.setOrigin("jaxrs_ejb_jpa_mysql");
		record.setRecordDateTime(generators.generateLocalDateTime());
		entityManager.persist(record);		
	}

	public Record updateRecord(String id, Record record) {
		Record toUpdate = entityManager.find(Record.class, id);
		if (record.getContent() != null) {
			toUpdate.setContent(record.getContent());
		}
		if (record.getRecordDateTime() != null) {
			toUpdate.setRecordDateTime(record.getRecordDateTime());
		}
		return entityManager.merge(toUpdate);
	}
	
	public void deleteControl(String id) {
		Record toDelete = entityManager.find(Record.class, id);
		entityManager.remove(toDelete);		
	}

}
