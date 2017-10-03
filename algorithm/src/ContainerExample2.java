
public class ContainerExample2 {

	public static void main(String[] args) {
		Container2<String, String> co1 = new Container2<String, String>();
		co1.set("hong", "do");
		String name1 = co1.getKey();
		String job = co1.getValue();
		System.out.println(job + " / " + name1 );
		
		Container2<String, Integer> co2 = new Container2<String, Integer>();
		co2.set("hong", 6);
		String name2 = co2.getKey();
		int val = co2.getValue();
		System.out.println(val + " / " + name2 );
	}
}

class Container2<T, K>{
	T name;
	K job;
	public void set(T name, K job){
		this.name = name;
		this.job = job;
	}
	public T getKey(){
		return name;
	}
	public K getValue(){
		return job;
	}
}
