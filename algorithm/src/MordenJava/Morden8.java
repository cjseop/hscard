package MordenJava;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*; // calling static method
import java.util.stream.Stream;

public class Morden8 {
	public static void main(String[] args) {
		System.out.println( "collect(toList) : " +
		    Stream.of(1,2,3,4,5)
			    .filter(i -> i > 2)
			    .map(i -> i *2)
			    .map(i -> "#" + i)
			    .collect(toList())
		);
		
		System.out.println( "collect(toSet) : " +
			    Stream.of(1,3,3,5,5)
				    .filter(i -> i > 2)
				    .map(i -> i *2)
				    .map(i -> "#" + i)
				    .collect(toSet())
			);
		
		System.out.println( "collect(joining) : " +
			    Stream.of(1,3,3,5,5)
				    .filter(i -> i > 2)
				    .map(i -> i *2)
				    .map(i -> "#" + i)
				    .collect(joining()) //String으로 만들어준다
			);
		
		System.out.println( "collect(joining(\", \")) : " +
			    Stream.of(1,3,3,5,5)
				    .filter(i -> i > 2)
				    .map(i -> i *2)
				    .map(i -> "#" + i)
				    .collect(joining(", ")) 
			);
		
		System.out.println( "collect(joining(\", \", \"[\", \"]\") : " +
			    Stream.of(1,3,3,5,5)
				    .filter(i -> i > 2)
				    .map(i -> i *2)
				    .map(i -> "#" + i)
				    .collect(joining(", ", "[", "]")) 
			);
		
		System.out.println( "collect(joining(\", \", \"[\", \"]\") : " +
			    Stream.of(1,3,3,5,5)
				    .filter(i -> i > 2)
				    .map(i -> i *2)
				    .map(i -> "#" + i)
				    .distinct() //set컬렉션처럼 유일한 값만 남음 
				    .collect(joining(", ", "[", "]")) 
			);
		
		System.out.println( "collect(toList distinct) : " +
			    Stream.of(1,3,3,5,5)
				    .filter(i -> i > 2)
				    .map(i -> i *2)
				    .map(i -> "#" + i)
				    .distinct()
				    .collect(toList())
			);
		
		final Integer three = 3;
		System.out.println(
				Stream.of(1,2,3,4,5)
				.filter(i -> i == three)
					  .findFirst()
		);
		
		final Integer n127 = 127;
		System.out.println(
				Stream.of(1,2,3,4,5,127) //Integer클래스는 cache가 127까지됨 같은오브젝취급
				.filter(i -> i == n127)
					  .findFirst()
		);
		
		final Integer n128 = 128;
		System.out.println(
				Stream.of(1,2,3,4,5,128) //128부터는 다른오브젝취급
				.filter(i -> i == n128)
					  .findFirst()
		);
		
		System.out.println(
				Stream.of(1,2,3,4,5,128) //128부터는 다른오브젝취급
				.filter(i -> i.equals(n128))
					  .findFirst()
		);
		
		System.out.println("filter(i -> i > three) : " +
				Stream.of(1,2,3,4,5) 
				.filter(i -> i > three)
				.count()
		);
		
		final List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		for(Integer number : numbers){ //external forEach
			
		}
		System.out.print("forEach : ");
				Stream.of(1,2,3,4,5) 
				.forEach(i -> System.out.print(i + " ")); //internal forEach
		
		
	}//end main
}// end class
