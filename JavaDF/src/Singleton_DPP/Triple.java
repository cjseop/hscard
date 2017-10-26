package Singleton_DPP;

public class Triple {
	private static Triple tp0 = new Triple();
	private static Triple tp1 = new Triple();
	private static Triple tp2 = new Triple();
	
	private Triple() {
		System.out.println("tp instance is created");
	}
	
	public static Triple getTPinstance(int id){
		switch (id) {
		case 0:
			return tp0;
		case 1:
			return tp1;
		case 2:
			return tp2;
		}
		return null;
		
	}
}
