package MordenJava;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Morden6 {

	public static void main(String[] args) {
		final List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		System.out.println(mapOld(numbers, i -> i*2));
		System.out.println(mapOld(numbers, i -> i));
		
		System.out.println(map(numbers, i -> i*2));
		System.out.println(map(numbers, Function.identity()));
		
	}//end main
	
	private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
		final Function<T, R> function;
//		if(mapper != null){
//			function = mapper;
//		}else{
//			function = t -> (R)t;
//		}
		final List<R> result = new ArrayList<>();
		for(final T t : list){
			result.add(mapper.apply(t));
		}
		return result;
	}
	
	private static <T, R> List<R> mapOld(List<T> list, Function<T, R> mapper) {
		final List<R> result = new ArrayList<>();
		for(final T t : list){
			result.add(mapper.apply(t));
		}
		return result;
	}
}//end class
