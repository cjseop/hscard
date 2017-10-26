package idacard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import framework.Factory;
import framework.Product;

public class IDCardFactory extends Factory{
	private int serial = 100;
	private HashMap database = new HashMap();

	@Override
	protected Product createProduct(String owner) {
		return new IDCard(owner, serial++);
	}

	@Override
	protected void registerProduct(Product product) {
		IDCard card = (IDCard)product;
		database.put(new Integer(card.getSireal()), card.getOwner());
	}
	
	public HashMap getDatabase(){
		return database;
	}
	
}
