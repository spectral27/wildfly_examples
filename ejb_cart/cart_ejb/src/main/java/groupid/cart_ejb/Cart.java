package groupid.cart_ejb;

import jakarta.ejb.Remote;

@Remote
public interface Cart {
	
	void add(String item);
	
	void remove(String item);
	
	void getStatus();

}
