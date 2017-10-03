package ch14;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FuncionalExample {
	private static List<Student> list = Arrays.asList(new Student("ABC", 80, 90), new Student("DEF", 90, 70));
	
	public static void printString(Function<Student, String>f){
		for(Student st : list){
			System.out.print(f.apply(st) + " ");
		}
		System.out.println();
	}
	
	public static void printInt(ToIntFunction<Student> f){
		for(Student st : list){
			System.out.print(f.applyAsInt(st) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("[name]");
		printString(t -> t.getName());
		
		System.out.println("[english]");
		printInt(t -> t.getEnglishScore());
		
		System.out.println("[math]");
		printInt(t -> t.getMathScore());
	}

}
