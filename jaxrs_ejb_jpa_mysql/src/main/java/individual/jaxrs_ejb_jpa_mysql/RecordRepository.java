package individual.jaxrs_ejb_jpa_mysql;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RecordRepository {
	
	List<Record> selectAllRecords();
	Record selectRecord(String id);
	void insertRecord(Record record);
	Record updateRecord(String id, Record record);
	void deleteControl(String id);

}
