package MordenJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//고계함수, 고차원함수 higher-order function
//함수가 함수를 리턴, 함수를 합칠 수 있다
public class Morden13 {
	public static void main(String[] args) {
		final Function<Function<Integer, String>, String> f = g -> g.apply(10);
		System.out.println(f.apply(i -> "#" + i));
		
		final Function<Integer, Function<Integer, Integer>> f2 = i -> i2 -> i + i2;
		System.out.println(
		f2.apply(1).apply(9)		
		);
		
		final List<Integer> list = Arrays.asList(1,2,3,4,5);
		final List<String> mappedList = map(list, i -> "#"+i);
		System.out.println(
				mappedList
		);
		
		System.out.println(
		list.stream()
			.filter(i -> i > 2)
			.map(i -> "#" + i)
			.collect(Collectors.toList())
		);
		
//		Function.identity();
		
		Function<Integer, Function<Integer, Function<Integer, Integer>>> f3 = i1 -> i2 -> i3 -> i1 + i2 + i3; //커링 : 함수가 계속 함수를 리턴하는 것
		System.out.println(
				f3.apply(2).apply(3).apply(4)
		);
		
		Function<Integer, Function<Integer, Integer>> plus10 = f3.apply(10);
		System.out.println(
				plus10.apply(1).apply(1)
		);
	}//end main
	
	private static <T,R> List<R> map(List<T> list, Function<T, R> mapper){
		final List<R> result = new ArrayList<>();
		for(final T t : list){
			result.add(mapper.apply(t));
		}
		return result;
	}
	
}//end class
