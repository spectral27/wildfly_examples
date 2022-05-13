package individual.jaxrs_ejb_jpa_mysql;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "records")
@SuppressWarnings("serial")
public class Record implements Serializable {

	@Id
	private String id;
	private String content;
	private String origin;
	private LocalDateTime recordDateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public LocalDateTime getRecordDateTime() {
		return recordDateTime;
	}

	public void setRecordDateTime(LocalDateTime recordDateTime) {
		this.recordDateTime = recordDateTime;
	}

}
