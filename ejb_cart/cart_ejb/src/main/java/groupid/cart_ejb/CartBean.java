package groupid.cart_ejb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.ejb.Stateful;

@Stateful
public class CartBean implements Cart {
	
	private List<String> items = new ArrayList<String>();
	
	public void add(String item) {
		items.add(item);
		
		System.out.println("Item \"" + item + "\" added to cart.");
	}

	public void remove(String item) {
		Iterator<String> iterator = items.iterator();
		
		while (iterator.hasNext()) {
			if (iterator.next().equals(item)) {
				items.remove(item);
				break;
			}
		}
		
		System.out.println("Item \"" + item + "\" removed from cart.");
	}

	public void getStatus() {
		System.out.println("Cart has " + items.size() + " items:");
		for (int i = 0; i < items.size(); i++) {
			System.out.println((i + 1) + ". " + items.get(i));
		}
	}

}
