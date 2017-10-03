package ch14;

public class UsingThis {
	public int outterfield = 10;
	
	class Inner {
		int innerfield = 20;
		
		void method(){
			MyFunctionalInterface fi = () -> {
				System.out.println("otter : " + outterfield);
				System.out.println("otter : " + UsingThis.this.outterfield);
				System.out.println("================================");
				System.out.println("inner : " + innerfield);
				System.out.println("otter : " + this.innerfield);
			};
			fi.method();
		}
	}
}
