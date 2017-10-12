
public class test2 {
	private test1 test1;
	
	public test2() {
		test1 = new test1("asd", "111");
	}
	
	public void setName(){
		System.out.println(test1.getName());
	}

	public test1 getTest1() {
		return test1;
	}

	public void setTest1(test1 test1) {
		this.test1 = test1;
	}
	
}
