package ch14;

public class UsingLocalVariable {
	void method(int arg){
		int localVal = 40;
		MyFunctionalInterface fi = () -> {
			System.out.println("arg : " + arg);
			System.out.println("localVal : " + localVal);
		};
		fi.method();
	}
}
