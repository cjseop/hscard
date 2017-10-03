public class UtilExample {
	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<>("hong", 35);
		Integer age = Util.getValue(pair, "hong");
		System.out.println(age);
		
		ChildPare<String, Integer> childPair = new ChildPare<>("sam", 20);
		Integer chiage = Util.getValue(childPair, "sun");
		System.out.println(chiage);
		
//		OtherPair<String, Integer> op = new OtherPair<>("sam2", 21);
//		Integer opage = Util.getValue(op, "sam2");
//		System.out.println(opage);
		
	}
}

class Pair<T, K>{
	private T t;
	private K k;
	public Pair(T t, K k) {
		this.t = t;
		this.k = k;
	}
	public T getT() {
		return t;
	}
	public K getK() {
		return k;
	}
	
}

class ChildPare<T, K> extends Pair<T, K>{
	public ChildPare(T t, K k) {
		super(t, k);
	}
}

class OtherPair<T, K>{
	private T t;
	private K k;
	public OtherPair(T t, K k) {
		this.t = t;
		this.k = k;
	}
	public T getT() {
		return t;
	}
	public K getK() {
		return k;
	}
	
}

class Util{
	public static Integer getValue(Pair<?extends String, ?extends Integer> pair, String string) {
		return pair.getT().equals(string) ? pair.getK() : null;
	}
	
}