package ch14;

public class UsingThisExample {
	public static void main(String[] args) {
		UsingThis us = new UsingThis();
		UsingThis.Inner inner = us.new Inner();
		inner.method();
		
		UsingLocalVariable lvo = new UsingLocalVariable();
		lvo.method(14);
	}

}
