package individual.jaxrs_ejb_jpa;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ControlRepository {
	
	List<Control> selectAllControls();
	Control selectControl(int id);
	void insertControl(Control control);
	Control updateControl(int id, Control control);
	void deleteControl(int id);

}
