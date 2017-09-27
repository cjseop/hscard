import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Morden5 {
	public static void main(String[] args) {
		BigDecimalToCurrency bdt = bd -> "$" + bd.toString();
		System.out.println(bdt.toCurrency(new BigDecimal("120.0")));
		
		final List<Product> products = Arrays.asList(new Product(1L, "A", new BigDecimal("10.00")),
													 new Product(2L, "B", new BigDecimal("55.50")),
													 new Product(3L, "C", new BigDecimal("17.45")),
													 new Product(4L, "D", new BigDecimal("20.00")),
													 new Product(5L, "E", new BigDecimal("110.00")));
		
	}

}

interface BigDecimalToCurrency {
	String toCurrency(BigDecimal value);
}

@AllArgsConstructor
@Data
class Product {
	private long id;
	private String name;
	private BigDecimal price;
}