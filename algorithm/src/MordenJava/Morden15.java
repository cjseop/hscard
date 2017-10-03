package MordenJava;

import java.math.BigDecimal;
import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Data;

//생성자를 Method reference로 사용하기
public class Morden15 {
	public static void main(String[] args) {
		//basic constructor
		final Section section = new Section(1);
		
		final Function<Integer, Section> sectionFactory = number -> new Section(number);
		final Section sec1Lambda = sectionFactory.apply(1);
		System.out.println(section);
		System.out.println(sec1Lambda);
		
		final Function<Integer, Section> sectionFactoryMethodReference = Section::new;
		final Section Sec2Method = sectionFactoryMethodReference.apply(3);
		System.out.println(Sec2Method);
		
		System.out.println("================================");
		final oldnProduct pd = new oldnProduct(1L, "A", new BigDecimal("100"));
		
		final oldProductCreator pc = oldnProduct::new;
		System.out.println(pc.create(2L, "B", new BigDecimal("200")));
		System.out.println(pd);
		
		final nProduct ap = creatPro(3L, "A", new BigDecimal("300"), ProductA::new);
		final nProduct bp = creatPro(4L, "B", new BigDecimal("400"), ProductB::new);
		System.out.println(ap);
		System.out.println(bp);
		
	}
	private static <T extends nProduct> T creatPro(final Long id, 
											final String name, 
											final BigDecimal price, 
											final ProductCreator<T> pc){
		if(id == null || id < 1L){
			throw new IllegalArgumentException("The id must be a positive long");
		}
		if(name == null || name.isEmpty()){
			throw new IllegalArgumentException("The name is not given");
		}
		if(price == null || price.compareTo(BigDecimal.ZERO) <= 0){
			throw new IllegalArgumentException("The price must be greater than 0");
		}
		return pc.create(id, name, price);
	}
}

@FunctionalInterface
interface ProductCreator<T extends nProduct>{
	T create(Long id, String name, BigDecimal price);
}

interface oldProductCreator{
	oldnProduct create(Long id, String name, BigDecimal price);
}


@AllArgsConstructor
@Data
class Section{
	private int number;
}

@AllArgsConstructor
@Data
class oldnProduct{
	private Long id;
	private String name;
	private BigDecimal price;
}

@AllArgsConstructor
@Data
abstract class nProduct{
	private Long id;
	private String name;
	private BigDecimal price;
}


class ProductA extends nProduct{

	public ProductA(Long id, String name, BigDecimal price) {
		super(id, name, price);
	}
	
	@Override
	public String toString() {
		return "A = " + super.toString();
	}
	
}

class ProductB extends nProduct{

	public ProductB(Long id, String name, BigDecimal price) {
		super(id, name, price);
	}
	
	@Override
	public String toString() {
		return "B = " + super.toString();
	}
	
}












