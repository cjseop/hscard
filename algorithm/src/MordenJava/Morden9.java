package MordenJava;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Morden9 {
	public static void main(String[] args) {
		final List<mProduct> products =
				Arrays.asList(
						new mProduct(1L, "A", new BigDecimal("100.50")),
						new mProduct(2L, "B", new BigDecimal("23.")),
						new mProduct(3L, "C", new BigDecimal("31.45")),
						new mProduct(4L, "D", new BigDecimal("80.20")),
						new mProduct(5L, "E", new BigDecimal("7.50"))
				);
		
		System.out.println("product.price >= 30 : " + 
		products.stream()
			    .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
			    .collect(toList())
		);
		
		System.out.println("=================================================");
		
		System.out.println("product.price >= 30 with joining(\"\\n\") : \n" + 
				products.stream()
					    .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
					    .map(product -> product.toString())
					    .collect(joining("\n"))
				);
				
		System.out.println("Intstream.sum : " + 
		IntStream.of(1,2,3,4,5)
				 .sum()
		);
		
		System.out.println("price sum : " + 
		products.stream()
				.map(product -> product.getPrice())
				.reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2)) //reduce(초기값, arity2 -> 같은타입결과리턴) 결과값과 2번째요소 그 다음요소로 하나씩 줄여감
		);
		
		System.out.println("Total price >= 30 : " + 
		products.stream()
				.filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
				.map(product -> product.getPrice())
				.reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
		);
		
		System.out.println("number of products.price >= 30 : " + 
				products.stream()
						.filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
						.count()
				);
		
		final mOrderedItem item1 = new mOrderedItem(1L, products.get(0), 1);
		final mOrderedItem item2 = new mOrderedItem(2L, products.get(2), 3);
		final mOrderedItem item3 = new mOrderedItem(3L, products.get(4), 10);
		
		final mOrder order = new mOrder(1L, Arrays.asList(item1, item2, item3));
		
		System.out.println("order Total Price : " +
				order.totalPrice()
		);
	}//end main
}//end class

@AllArgsConstructor
@Data
class mProduct {
	private Long id;
	private String name;
	private BigDecimal price;
}

@AllArgsConstructor
@Data
class mOrderedItem {
	private Long id;
	private mProduct product;
	private int qty;
	
	public BigDecimal getTotalPrice(){
		return product.getPrice().multiply(new BigDecimal(qty));
	}
}

@AllArgsConstructor
@Data
class mOrder {
	private Long id;
	private List<mOrderedItem> items;
	public BigDecimal totalPrice(){
		return items.stream()
					.map(item -> item.getTotalPrice())
					.reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2));
	}
}







