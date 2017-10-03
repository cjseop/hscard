
public class ContainerExample {

	public static void main(String[] args) {
		Container<String> co1 = new Container<String>();
		co1.set("hong");
		String str = co1.get();
		System.out.println(str);
		
		Container<Integer> co2 = new Container<Integer>();
		co2.set(6);
		int val = co2.get();
		System.out.println(val);
	}
}

class Container<T>{
	T t;
	public void set(T t){
		this.t= t;
	}
	public T get(){
		return t;
	}
}
