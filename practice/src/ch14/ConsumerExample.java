package ch14;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {
	public static void main(String[] args) {
		Consumer<String> consumer = t -> System.out.println(t + "8");
		consumer.accept("Java");
		
		BiConsumer<String, Integer> bigconsumer = (t,i) -> System.out.println(t + i);
		bigconsumer.accept("Java", 8);
		
		DoubleConsumer dc = d -> System.out.println("Java" + d);
		dc.accept(8);
		
		ObjIntConsumer<String> ojc = (t,i) -> System.out.println(t + i);
		ojc.accept("Java", 8);
	}

}
