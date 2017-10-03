package MordenJava;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//Method Reference
/*
 Function : 호출이 가능한 코드
 Method : 특정 객체(Object)에 종속된 호출가능한 코드
 */
public class Morden14 {
	public static void main(String[] args) {
		Arrays.asList(1,2,3,4,5)
			  .forEach(System.out::println);
//			  .forEach(i -> System.out.println(i);
	
	System.out.println(
	Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
		  .stream()
//		  .sorted((bd1, bd2) -> bd1.compareTo(bd2))
//		  .sorted(BigDecimalUtil::compare) static메소드 사용하기
		  .sorted(BigDecimal::compareTo)
		  .collect(Collectors.toList())
	);
	
//	final String targetString = "c";
	System.out.println(
	Arrays.asList("a", "b", "c", "d")
		  .stream()
//		  .anyMatch(targetString::equals)
		  .anyMatch("c"::equals)
//		  .anyMatch(x -> x.equals("c"))
	);
	
	methodReference03();
	
	}//end main
	private static void methodReference03(){
		/* First Class Function*/
		/*
		 * A Function can be passed as a parameter to another function.
		 * Using Lambda Expression
		 */
		System.out.println("Lambda Expression : " +
				testFirstClassfunction1(3, i -> String.valueOf(i * 2))
		);
		
		/*
		 * Using Method Reference  
		 */
		System.out.println("Using Method Reference : " +
				testFirstClassfunction1(3, Morden14::doubleThenToString)
		);
		
		/**
		 * A function can be returned as the result of another function 
		 */
		/* 
		 * Using Lambda Expression
		 */
		Function<Integer, String> fl = getDoublethanToStringUsingLambda();
		String resultFromfl = fl.apply(3);
		System.out.println(resultFromfl);
		
		/*
		 * Using Method Reference 
		 */
		final Function<Integer, String> fmr = getDoublethanToStringUsingMethodReference();
		final String rsultFromfmr = fmr.apply(3);
		System.out.println(rsultFromfmr);
		
		System.out.println("=====================================================");
		
		/**
		 * A function can be stored in the data structure.
		 */
		/* 
		 * Using Lambda Expression
		 */
		final List<Function<Integer, String>> fsL = Arrays.asList(i -> String.valueOf(i * 2));
		for(final Function<Integer, String> f : fsL){
			final String result = f.apply(4);
			System.out.println(result);
		}
		
		/*
		 * Using Method Reference 
		 */
		final List<Function<Integer, String>> fsMr = Arrays.asList(Morden14::doubleThenToString);
		for(final Function<Integer, String> f : fsMr){
			final String result = f.apply(4);
			System.out.println(result);
		}
		
		System.out.println("=====================================================");
		/* 
		 * Using Lambda Expression
		 */
		final Function<Integer, String> fl2 = i -> String.valueOf(i * 2);
		final String resultfl2 = fl2.apply(5);
		System.out.println(resultfl2);
		
		/*
		 * Using Method Reference 
		 */
		final Function<Integer, String> fsmr2 = Morden14::doubleThenToString;
		final String resultfsmr2 = fsmr2.apply(5);
		System.out.println(resultfsmr2);
		
		System.out.println("=====================================================");
		/*
		 * Both Lambda Expresion and Method Reference 
		 */
		final List<Function<Integer, String>> fsboth = Arrays.asList(i -> String.valueOf(i * 2), Morden14::doubleThenToString, Morden14::addHashPrefix);
		for(final Function<Integer, String> f : fsboth){
			final String result = f.apply(7);
			System.out.println(result);
		}
	}
	
	private static String addHashPrefix(int number){
		return "#" + number;
	}
	
	private static String doubleThenToString(int n){
		return String.valueOf(n * 2);
	}
	
	private static String testFirstClassfunction1(int n, Function<Integer, String> f){
		return "The result is " + f.apply(n);
	}
	
	private static Function<Integer, String> getDoublethanToStringUsingLambda(){
		return i -> String.valueOf(i * 2);
	}
	
	private static Function<Integer, String> getDoublethanToStringUsingMethodReference() {
		return Morden14::doubleThenToString;
	}
	
	
} //end class

class BigDecimalUtil{
	public static int compare(BigDecimal bd1, BigDecimal bd2){
		return bd1.compareTo(bd2);
	}
}