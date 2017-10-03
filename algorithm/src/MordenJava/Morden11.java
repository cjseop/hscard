package MordenJava;

public class Morden11 {
	public static void main(String[] args) {
		int number = 100;
		
		testClosure("Anonymous Class", new Runnable() {
			@Override
			public void run() {
				System.out.println(number);
			}
		});
		
		testClosure("Lambda", () -> System.out.println(number));
		
	}//end main

	public static void testClosure(final String name, Runnable runnable){
		System.out.println("================================");
		System.out.print("Start " + name + " : ");
		runnable.run();
		System.out.println("================================");
	}
}//end close
