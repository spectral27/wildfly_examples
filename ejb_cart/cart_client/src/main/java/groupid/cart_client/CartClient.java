package groupid.cart_client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import groupid.cart_ejb.Cart;

public class CartClient {

	public static Cart lookupCartEJB() throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		Context context = new InitialContext(jndiProperties);
		return (Cart) context.lookup("ejb:/cart-ejb/CartBean!groupid.cart_ejb.Cart?stateful");
	}

	public static void main(String[] args) throws NamingException {
		Cart cart = lookupCartEJB();
		
		cart.add("item1");
		cart.add("item2");
		
		cart.getStatus();
	}

}
