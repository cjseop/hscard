
public class test3 {

	public static void main(String[] args) {
		test2 test2 = new test2();
		test2.setName();
		test1 test1 = new test1();
		test1.setName("set t3");
		test2.setTest1(test1);
		System.out.println(test1.getName());
		test2.setName();
		
	}

}
