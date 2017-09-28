import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

//Stream : 게으른 컬렉션 빌더(효율적, 결과를 요청할 때 연산을 시작한다)
public class Morden7 {
	public static void main(String[] args) {
		//IntStream.range(0, 10).forEach(i -> System.out.print(i + " "));
		//IntStream.rangeClosed(0, 10).forEach(i -> System.out.print(i + " "));
		//IntStream.iterate(1, i -> i + 1).forEach(i -> System.out.print(i + " "));
		//Stream.iterate(BigInteger.ONE, i -> i.add(BigInteger.ONE)).forEach(i -> System.out.print(i + " ")); //무한
		

		//Stream.of(1,2,3,4,5).forEach(i->System.out.print(i + " "));
//스트림사용전
		final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8 ,9, 10);
		Integer result = null;
		for(final Integer number : numbers){
			if(number > 3 && number < 9){
				final Integer newNumber = number * 2;
				if(newNumber > 10){
					result = newNumber;
				}
			}
		}
		System.out.println("Imperative Result : " + result);

//스트림사용 (효울적연산 15번연산)
		System.out.println("Functional Result : " + numbers.stream()
		.filter(i -> i > 3)
		.filter(i -> i < 9)
		.map(i -> i * 2)
		.filter(i -> i > 10 )
		.findFirst());
		
//functional사용 (비효울적 27번연산)
		final List<Integer> gt3 = filter(numbers, i-> i > 3);
		final List<Integer> ls9 = filter(numbers, i-> i < 9);
		final List<Integer> doubled = map(ls9, i-> i * 2);
		final List<Integer> gt10 = filter(doubled, i -> i > 10);
		System.out.println(gt10.get(0));
		
	}// end main

	private static <T> List<T> filter(List<T> list, Predicate<T> predicate){
		final List<T> result = new ArrayList<>();
		for(final T t : list){
			if(predicate.test(t)){
				result.add(t);
			}
		}
		return result;
	}
	
	private static <T, R> List<R> map(List<T> list, Function<T, R> mapper){
		final List<R> result = new ArrayList<>();
		for(final T t : list){
				result.add(mapper.apply(t));
		}
		return result;
	}
	
	
}// end class
