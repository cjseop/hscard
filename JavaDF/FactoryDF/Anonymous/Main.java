package Anonymous;

import framework.Factory;
import framework.Product;
import idacard.IDCardFactory;

public class Main {

	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product c1 = factory.create("A");
		Product c2 = factory.create("B");
		Product c3 = factory.create("C");
		c1.use();
		c2.use();
		c3.use();
	}

}
