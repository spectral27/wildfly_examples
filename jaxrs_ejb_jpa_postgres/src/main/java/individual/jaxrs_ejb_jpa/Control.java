package individual.jaxrs_ejb_jpa;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.json.bind.annotation.JsonbNillable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "control", schema = "i49_sch")
@JsonbNillable(true)
public class Control implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean active;
	
	private LocalDateTime deleted;
	private String description;
	private String name;

	@Column(name = "controltype_id")
	private int controltypeId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getDeleted() {
		return deleted;
	}

	public void setDeleted(LocalDateTime deleted) {
		this.deleted = deleted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getControltypeId() {
		return controltypeId;
	}

	public void setControltypeId(int controltypeId) {
		this.controltypeId = controltypeId;
	}

}
