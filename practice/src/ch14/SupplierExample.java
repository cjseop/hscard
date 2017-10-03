package ch14;

import java.util.function.IntSupplier;

public class SupplierExample {

	public static void main(String[] args) {
		IntSupplier is = () -> {
			int num = (int)(Math.random() * 6) + 1;
			return num;
		};
		System.out.println(is.getAsInt());
	}

}
